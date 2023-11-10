package cashewnut.biz.home.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class HomeApiController {

    /**
     * 기본 접근 권한 및 토큰
     */
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String currentDate = dateFormat.format(date);
    @Value("${global.contentType}")
    private String contentType;

    @Value("${global.authorization}")
    private String authorization;
    @Value("${global.appkey}")
    private String appkey;
    @Value("${global.appsecret}")
    private String appsecret;

    @GetMapping("/api/closed_days")
    public Map<String, Object> ClosedDays() {
        Map<String, Object> closedDaysMap = new HashMap<>();

        try {
            String apiUrl = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/chk-holiday";
            String tr_id = "CTCA0903R";
            String custtype = "P";
            String param1 = currentDate;
            String param2 = "";
            String param3 = "";

            URL url = new URL(apiUrl + "?BASS_DT=" + param1
                    + "&CTX_AREA_NK=" + param2
                    + "&CTX_AREA_FK=" + param3
            );

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Set headers
            conn.setRequestProperty("content-type", contentType);
            conn.setRequestProperty("authorization", "Bearer "+authorization);
            conn.setRequestProperty("appKey",appkey);
            conn.setRequestProperty("appSecret",appsecret);
            conn.setRequestProperty("tr_id", tr_id);
            conn.setRequestProperty("custtype", custtype);

            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();

                String content_type = conn.getHeaderField("content-type");
                String trid = conn.getHeaderField("tr_id");
                String trcont = conn.getHeaderField("tr_cont");
                String gt_uid = conn.getHeaderField("gt_uid");

                // 데이터를 JSON 형태로 responseMap에 추가
                closedDaysMap.put("content_type", content_type);
                closedDaysMap.put("tr_id", trid);
                closedDaysMap.put("tr_cont", trcont);
                closedDaysMap.put("gt_uid", gt_uid);
                closedDaysMap.put("response", response.toString());
            } else {
                System.out.println("HTTP Request Failed with Response Code: " + responseCode);
            }
            System.out.println("responseMap : " + closedDaysMap);
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return closedDaysMap;
    }
}

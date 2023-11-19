package cashewnut.biz.home.api;

import cashewnut.biz.home.dto.ThemaTotalIndexDto;
import cashewnut.biz.home.dto.WorldIndexDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class HomeApiController {
    // 현재날짜
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String currentDate = dateFormat.format(date);
    // 지난날짜
    LocalDate localDate = LocalDate.now();
    LocalDate lastLocalDate = localDate.plusMonths(-6);
    // 날짜를 문자열로 변환
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    String lastDate = lastLocalDate.format(formatter);


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
            System.out.println("ClosedDaysMap : " + closedDaysMap);
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return closedDaysMap;
    }

    @RequestMapping("/api/worldStockIndex")
    public Map<String, Object> WorldStockIndex(@RequestBody WorldIndexDto worldIndexDto) {
        Map<String, Object> worldStockIndexMap = new HashMap<>();

        try {
            String apiUrl = "https://openapi.koreainvestment.com:9443/uapi/overseas-price/v1/quotations/inquire-daily-chartprice";
            String tr_id = "FHKST03030100";
            String param1 = "N";
            String param2 = worldIndexDto.getFidInputIscd();
            String param3 = currentDate;
            String param4 = currentDate;
            String param5 = "D";

            URL url = new URL(apiUrl + "?FID_COND_MRKT_DIV_CODE=" + param1
                    + "&FID_INPUT_ISCD=" + param2
                    + "&FID_INPUT_DATE_1=" + param3
                    + "&FID_INPUT_DATE_2=" + param4
                    + "&FID_PERIOD_DIV_CODE=" + param5
            );

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Set headers
            conn.setRequestProperty("content-type", contentType);
            conn.setRequestProperty("authorization", "Bearer "+authorization);
            conn.setRequestProperty("appKey",appkey);
            conn.setRequestProperty("appSecret",appsecret);
            conn.setRequestProperty("tr_id", tr_id);

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
                worldStockIndexMap.put("content_type", content_type);
                worldStockIndexMap.put("tr_id", trid);
                worldStockIndexMap.put("tr_cont", trcont);
                worldStockIndexMap.put("gt_uid", gt_uid);
                worldStockIndexMap.put("response", response.toString());
            } else {
                System.out.println("HTTP Request Failed with Response Code: " + responseCode);
            }
            System.out.println("WorldStockIndexMap : " + worldStockIndexMap);
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return worldStockIndexMap;
    }

    @RequestMapping("/api/themaTotalIndex")
    public Map<String, Object> ThemaTotalIndex(@RequestBody ThemaTotalIndexDto themaTotalIndexDto) {
        Map<String, Object> themaTotalIndexMap = new HashMap<>();

        try {
            String apiUrl = "https://openapi.koreainvestment.com:9443/uapi/overseas-price/v1/quotations/inquire-daily-chartprice";
            String tr_id = "FHKUP03500100";
            String param1 = "U";
            String param2 = "0001";
            if(themaTotalIndexDto.getFidInputIscd() != null && themaTotalIndexDto.getFidInputIscd() != "") {
                param2 = themaTotalIndexDto.getFidInputIscd();
            }
            String param3 = lastDate;
            String param4 = currentDate;
            String param5 = "D";
            if(themaTotalIndexDto.getFidPeriodDivCode() != null && themaTotalIndexDto.getFidPeriodDivCode() != "") {
                param5 = themaTotalIndexDto.getFidPeriodDivCode();
            }

            URL url = new URL(apiUrl + "?FID_COND_MRKT_DIV_CODE=" + param1
                    + "&FID_INPUT_ISCD=" + param2
                    + "&FID_INPUT_DATE_1=" + param3
                    + "&FID_INPUT_DATE_2=" + param4
                    + "&FID_PERIOD_DIV_CODE=" + param5
            );

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Set headers
            conn.setRequestProperty("content-type", contentType);
            conn.setRequestProperty("authorization", "Bearer "+authorization);
            conn.setRequestProperty("appKey",appkey);
            conn.setRequestProperty("appSecret",appsecret);
            conn.setRequestProperty("tr_id", tr_id);

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
                themaTotalIndexMap.put("content_type", content_type);
                themaTotalIndexMap.put("tr_id", trid);
                themaTotalIndexMap.put("tr_cont", trcont);
                themaTotalIndexMap.put("gt_uid", gt_uid);
                themaTotalIndexMap.put("response", response.toString());
            } else {
                System.out.println("HTTP Request Failed with Response Code: " + responseCode);
            }
            System.out.println("ThemaTotalIndexMap : " + themaTotalIndexMap);
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return themaTotalIndexMap;
    }

    @RequestMapping("/api/transaction_amount")
    public Map<String, Object>TransactionAmount() {
        Map<String, Object> transactionAmountMap = new HashMap<>();

        try {
            String apiUrl = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/volume-rank";
            String tr_id = "FHPST01710000";
            String custtype = "P";
            String param1 = "J";
            String param2 = "20171";
            String param3 = "0000";
            String param4 = "0";
            String param5 = "3";
            String param6 = "111111111";
            String param7 = "000000";
            String param8 = "";
            String param9 = "";
            String param10 = "";
            String param11 = "";

            URL url = new URL(apiUrl + "?FID_COND_MRKT_DIV_CODE=" + param1
                    + "&FID_COND_SCR_DIV_CODE=" + param2
                    + "&FID_INPUT_ISCD=" + param3
                    + "&FID_DIV_CLS_CODE=" + param4
                    + "&FID_BLNG_CLS_CODE=" + param5
                    + "&FID_TRGT_CLS_CODE=" + param6
                    + "&FID_TRGT_EXLS_CLS_CODE=" + param7
                    + "&FID_INPUT_PRICE_1=" + param8
                    + "&FID_INPUT_PRICE_2=" + param9
                    + "&FID_VOL_CNT=" + param10
                    + "&FID_INPUT_DATE_1=" + param11
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
                String tr_cont = conn.getHeaderField("tr_cont");
                String gt_uid = conn.getHeaderField("gt_uid");

                // 데이터를 JSON 형태로 responseMap에 추가
                transactionAmountMap.put("content_type", content_type);
                transactionAmountMap.put("tr_id", trid);
                transactionAmountMap.put("tr_cont", tr_cont);
                transactionAmountMap.put("gt_uid", gt_uid);
                transactionAmountMap.put("response", response.toString());
            } else {
                System.out.println("HTTP Request Failed with Response Code: " + responseCode);
            }
            System.out.println("responseMap : " + transactionAmountMap);
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactionAmountMap;
    }
}

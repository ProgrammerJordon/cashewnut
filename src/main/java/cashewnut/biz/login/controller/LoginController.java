package cashewnut.biz.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "/login/VIEW009001M";
    }

    @RequestMapping("/kakao/oauth/token")
    @ResponseBody
    public Map<String, Object> kakaoOauthToken() {
        Map<String, Object> kakaoOauthTokenMap = new HashMap<>();
        try {
            String apiUrl = "https://kauth.kakao.com/oauth/token";
            String param1 = "authorization_code";
            String param2 = "1cf7949d3eb1d9695896d35734ccd915";
            String param3 = "http://localhost:5252/home";
            String param4 = "1cf7949d3eb1d9695896d35734ccd915";

            URL url = new URL(apiUrl
                    + "?grant_type=" + param1
                    + "&client_id=" + param2
                    + "&redirect_uri=" + param3
                    + "&code=" + param4
            );

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");

            // Set headers
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();

                String token_type = conn.getHeaderField("token_type");
                String access_token = conn.getHeaderField("access_token");
                String id_token = conn.getHeaderField("id_token");
                String expires_in = conn.getHeaderField("expires_in");
                String refresh_token = conn.getHeaderField("refresh_token");
                String refresh_token_expires_in = conn.getHeaderField("refresh_token_expires_in");
                String scope = conn.getHeaderField("scope");

                // 데이터를 JSON 형태로 responseMap에 추가
                kakaoOauthTokenMap.put("token_type", token_type);
                kakaoOauthTokenMap.put("access_token", access_token);
                kakaoOauthTokenMap.put("id_token", id_token);
                kakaoOauthTokenMap.put("expires_in", expires_in);
                kakaoOauthTokenMap.put("refresh_token", refresh_token);
                kakaoOauthTokenMap.put("refresh_token_expires_in", refresh_token_expires_in);
                kakaoOauthTokenMap.put("scope", scope);
                kakaoOauthTokenMap.put("response", response.toString());
            } else {
                System.out.println("HTTP Request Failed with Response Code: " + responseCode);
            }
            System.out.println("memberBuySellCompanySearchMap : " + kakaoOauthTokenMap);
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kakaoOauthTokenMap;
    }
}

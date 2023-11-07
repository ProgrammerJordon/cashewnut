//package cashewnut.common.websocket;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class ApiClient {
//    public static void main(String[] args) {
//        try {
//            String apiUrl = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-price";
//            String authorization = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0b2tlbiIsImF1ZCI6ImM1MmEyMmIzLTFlZjEtNDViMy05MzU5LTk5ZmU3OWM2N2JhYyIsImlzcyI6InVub2d3IiwiZXhwIjoxNjk5MjAxMDY1LCJpYXQiOjE2OTkxMTQ2NjUsImp0aSI6IlBTUVdaZzFOV3RjeFRUQ05ZSWdKN0xZb2FjSngzOFZ2Q1htUSJ9.rjxkjXY6jwxK-QtLPnqBnHUaA-ZJUWAgWpKfScnvWiRYylNq4b6qinZyTL4tOtkKwVTo8KKMRtp1lBylBHOOnQ";
//            String appkey = "PSQWZg1NWtcxTTCNYIgJ7LYoacJx38VvCXmQ";
//            String appsecret = "dSPcqjO3Gdk9nJiVnkQSFE8JoDZyZ1XbrJpha+732iU8F98y45rVW45QHR392B38+tCofP6moWQCYK/S6QqW9g+aYS5EPWPEr0UvlEH1thIMqyU2yvApY+Wp/5syOY2j5cnhieyRQDcqRsN/HQalrPxPJbXHgzsu9SS3NmX4hp91w1OJ6cs=";
//            String tr_id = "FHKST01010100";
//            String param1 = "J"; // Replace with the actual market code
//            String param2 = "000660"; // Replace with the actual input code
//
//            URL url = new URL(apiUrl + "?fid_cond_mrkt_div_code=" + param1 + "&fid_input_iscd=" + param2);
//
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//
//            // Set headers
//            conn.setRequestProperty("authorization", "Bearer "+authorization);
//            conn.setRequestProperty("appKey",appkey);
//            conn.setRequestProperty("appSecret",appsecret);
//            conn.setRequestProperty("tr_id", tr_id);
//
//            int responseCode = conn.getResponseCode();
//
//            if (responseCode == 200) {
//                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                String inputLine;
//                StringBuilder response = new StringBuilder();
//
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//
//                in.close();
//
//                String content_type = conn.getHeaderField("content-type");
//                String trid = conn.getHeaderField("tr_id");
//                String tr_cont = conn.getHeaderField("tr_cont");
//                String gt_uid = conn.getHeaderField("gt_uid");
//
//                System.out.println("content_type: " + content_type);
//                System.out.println("tr_id: " + trid);
//                System.out.println("Response tr_cont: " + tr_cont);
//                System.out.println("Response gt_uid: " + gt_uid);
//                System.out.println("Response Body: " + response.toString());
//            } else {
//                System.out.println("HTTP Request Failed with Response Code: " + responseCode);
//            }
//            conn.disconnect();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//

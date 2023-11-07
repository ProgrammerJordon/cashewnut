package cashewnut.biz.main.api;

import lombok.RequiredArgsConstructor;
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
public class MainApiController {

    /**
     * 기본 접근 권한 및 토큰
     */
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String currentDate = dateFormat.format(date);
    String contentType = "application/json";
    String authorization = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0b2tlbiIsImF1ZCI6IjIxNjdhM2NkLTI5MmYtNGIxZC1hMTkyLTkxNjQ5N2EzZWVmOSIsImlzcyI6InVub2d3IiwiZXhwIjoxNjk5NDIyODg0LCJpYXQiOjE2OTkzMzY0ODQsImp0aSI6IlBTUVdaZzFOV3RjeFRUQ05ZSWdKN0xZb2FjSngzOFZ2Q1htUSJ9.oZkx6Jsj51z7-bEjm-0SkjKJ2LLvk5GT_vr3PX3LUzyNP6KiTG8E267uDs3gOwlo5xBD80O6eSKzePrC0NlJ5Q";
    String appkey = "PSQWZg1NWtcxTTCNYIgJ7LYoacJx38VvCXmQ";
    String appsecret = "dSPcqjO3Gdk9nJiVnkQSFE8JoDZyZ1XbrJpha+732iU8F98y45rVW45QHR392B38+tCofP6moWQCYK/S6QqW9g+aYS5EPWPEr0UvlEH1thIMqyU2yvApY+Wp/5syOY2j5cnhieyRQDcqRsN/HQalrPxPJbXHgzsu9SS3NmX4hp91w1OJ6cs=";

    @GetMapping("/api/domestic_stock_price")
    public Map<String, Object> DomesticStockPrice() {
        Map<String, Object> domesticStockPriceMap = new HashMap<>();

        try {
            String apiUrl = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-price";
            String tr_id = "FHKST01010100";
            String param1 = "J";
            String param2 = "000660";

            URL url = new URL(apiUrl + "?fid_cond_mrkt_div_code=" + param1 + "&fid_input_iscd=" + param2);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Set headers
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
                String tr_cont = conn.getHeaderField("tr_cont");
                String gt_uid = conn.getHeaderField("gt_uid");

                // 데이터를 JSON 형태로 responseMap에 추가
                domesticStockPriceMap.put("content_type", content_type);
                domesticStockPriceMap.put("tr_id", trid);
                domesticStockPriceMap.put("tr_cont", tr_cont);
                domesticStockPriceMap.put("gt_uid", gt_uid);
                domesticStockPriceMap.put("response", response.toString());
            } else {
                System.out.println("HTTP Request Failed with Response Code: " + responseCode);
            }
            System.out.println("responseMap : " + domesticStockPriceMap);
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return domesticStockPriceMap;
    }

    @GetMapping("/api/transaction_amount")
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

    @GetMapping("/api/commodity_search")
    public Map<String, Object> CommoditySearch() {
        Map<String, Object> commoditySearchMap = new HashMap<>();

        try {
            String apiUrl = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/search-info";
            String tr_id = "CTPF1604R";
            String custtype = "P";
            String param1 = "000660";
            String param2 = "300";

            URL url = new URL(apiUrl + "?PDNO=" + param1 + "&PRDT_TYPE_CD=" + param2);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Set headers
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
                commoditySearchMap.put("content_type", content_type);
                commoditySearchMap.put("tr_id", trid);
                commoditySearchMap.put("tr_cont", tr_cont);
                commoditySearchMap.put("gt_uid", gt_uid);
                commoditySearchMap.put("response", response.toString());
            } else {
                System.out.println("HTTP Request Failed with Response Code: " + responseCode);
            }
            System.out.println("responseMap : " + commoditySearchMap);
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commoditySearchMap;
    }

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

    @GetMapping("/api/investor_trend_estimate")
    public Map<String, Object> InvestorTrendEstimate() {
        Map<String, Object> investorTrendEstimateMap = new HashMap<>();

        try {
            String apiUrl = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/investor-trend-estimate";
            String tr_id = "HHPTJ04160200";
            String custtype = "P";
            String param1 = "000660";

            URL url = new URL(apiUrl + "?MKSC_SHRN_ISCD=" + param1
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
                investorTrendEstimateMap.put("content_type", content_type);
                investorTrendEstimateMap.put("tr_id", trid);
                investorTrendEstimateMap.put("tr_cont", trcont);
                investorTrendEstimateMap.put("gt_uid", gt_uid);
                investorTrendEstimateMap.put("response", response.toString());
            } else {
                System.out.println("HTTP Request Failed with Response Code: " + responseCode);
            }
            System.out.println("responseMap : " + investorTrendEstimateMap);
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return investorTrendEstimateMap;
    }

    @GetMapping("/api/program_trade_estimate")
    public Map<String, Object> ProgramTradeEstimate() {
        Map<String, Object> programTradeEstimateMap = new HashMap<>();

        try {
            String apiUrl = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/program-trade-by-stock";
            String tr_id = "FHPPG04650100";
            String custtype = "P";
            String param1 = "000660";

            URL url = new URL(apiUrl + "?fid_input_iscd=" + param1
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
                programTradeEstimateMap.put("content_type", content_type);
                programTradeEstimateMap.put("tr_id", trid);
                programTradeEstimateMap.put("tr_cont", trcont);
                programTradeEstimateMap.put("gt_uid", gt_uid);
                programTradeEstimateMap.put("response", response.toString());
            } else {
                System.out.println("HTTP Request Failed with Response Code: " + responseCode);
            }
            System.out.println("responseMap : " + programTradeEstimateMap);
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return programTradeEstimateMap;
    }

    @GetMapping("/api/investor-search")
    public Map<String, Object> InvestorSearch() {
        Map<String, Object> investorSearchMap = new HashMap<>();

        try {
            String apiUrl = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/search-info";
            String tr_id = "FHKST01010900";
            String param1 = "J";
            String param2 = "000660";

            URL url = new URL(apiUrl + "?FID_COND_MRKT_DIV_CODE=" + param1 + "&FID_INPUT_ISCD=" + param2);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Set headers
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
                String tr_cont = conn.getHeaderField("tr_cont");
                String gt_uid = conn.getHeaderField("gt_uid");

                // 데이터를 JSON 형태로 responseMap에 추가
                investorSearchMap.put("content_type", content_type);
                investorSearchMap.put("tr_id", trid);
                investorSearchMap.put("tr_cont", tr_cont);
                investorSearchMap.put("gt_uid", gt_uid);
                investorSearchMap.put("response", response.toString());
            } else {
                System.out.println("HTTP Request Failed with Response Code: " + responseCode);
            }
            System.out.println("responseMap : " + investorSearchMap);
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return investorSearchMap;
    }

    @GetMapping("/api/member-buy-sell-company")
    public Map<String, Object> MemberBuySellCompanySearch() {
        Map<String, Object> memberBuySellCompanySearchMap = new HashMap<>();

        try {
            String apiUrl = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-member";
            String tr_id = "FHKST01010600";
            String param1 = "J";
            String param2 = "000660";

            URL url = new URL(apiUrl + "?FID_COND_MRKT_DIV_CODE=" + param1 + "&FID_INPUT_ISCD=" + param2);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Set headers
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
                String tr_cont = conn.getHeaderField("tr_cont");
                String gt_uid = conn.getHeaderField("gt_uid");

                // 데이터를 JSON 형태로 responseMap에 추가
                memberBuySellCompanySearchMap.put("content_type", content_type);
                memberBuySellCompanySearchMap.put("tr_id", trid);
                memberBuySellCompanySearchMap.put("tr_cont", tr_cont);
                memberBuySellCompanySearchMap.put("gt_uid", gt_uid);
                memberBuySellCompanySearchMap.put("response", response.toString());
            } else {
                System.out.println("HTTP Request Failed with Response Code: " + responseCode);
            }
            System.out.println("responseMap : " + memberBuySellCompanySearchMap);
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return memberBuySellCompanySearchMap;
    }
}

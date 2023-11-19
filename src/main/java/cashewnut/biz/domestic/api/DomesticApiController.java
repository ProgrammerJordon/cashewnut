package cashewnut.biz.domestic.api;

import cashewnut.biz.domestic.dto.DomesticStockDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class DomesticApiController {

    @Value("${global.contentType}")
    private String contentType;
    @Value("${global.authorization}")
    private String authorization;
    @Value("${global.appkey}")
    private String appkey;
    @Value("${global.appsecret}")
    private String appsecret;
    private String basicStockId = "005930"; // 삼성전자
    @RequestMapping("/api/domestic_stock_price")
    public Map<String, Object> DomesticStockPrice(@RequestBody DomesticStockDto domesticStockDto) {
        Map<String, Object> domesticStockPriceMap = new HashMap<>();

        System.out.println("stockId 파라미터값 : " + domesticStockDto.getStockId());

        try {
            String apiUrl = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-price";
            String tr_id = "FHKST01010100";
            String param1 = "J";
            String param2 = basicStockId;
            if(domesticStockDto.getStockId() != null && domesticStockDto.getStockId() != "") {
                param2 = domesticStockDto.getStockId();
            }

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

    @RequestMapping("/api/commodity_search")
    public Map<String, Object> CommoditySearch(@RequestBody DomesticStockDto domesticStockDto) {
        Map<String, Object> commoditySearchMap = new HashMap<>();
        System.out.println("stockId 파라미터 : " + domesticStockDto.getStockId());
        try {
            String apiUrl = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/search-info";
            String tr_id = "CTPF1604R";
            String custtype = "P";
            String param1 = basicStockId;
            if(domesticStockDto.getStockId() != null && domesticStockDto.getStockId() != "") {
                param1 = domesticStockDto.getStockId().trim();
            }
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

    @RequestMapping("/api/investor_trend_estimate")
    public Map<String, Object> InvestorTrendEstimate(@RequestBody DomesticStockDto domesticStockDto) {
        Map<String, Object> investorTrendEstimateMap = new HashMap<>();

        try {
            String apiUrl = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/investor-trend-estimate";
            String tr_id = "HHPTJ04160200";
            String custtype = "P";
            String param1 = basicStockId;
            if(domesticStockDto.getStockId() != null && domesticStockDto.getStockId() != "") {
                param1 = domesticStockDto.getStockId();
            }

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

    @RequestMapping("/api/investor-search")
    public Map<String, Object> InvestorSearch(@RequestBody DomesticStockDto domesticStockDto) {
        Map<String, Object> investorSearchMap = new HashMap<>();

        try {
            String apiUrl = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/search-info";
            String tr_id = "FHKST01010900";
            String param1 = "J";
            String param2 = basicStockId;
            if(domesticStockDto.getStockId() != null && domesticStockDto.getStockId() != "") {
                param2 = domesticStockDto.getStockId();
            }

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

    @RequestMapping("/api/program_trade_estimate")
    public Map<String, Object> ProgramTradeEstimate(@RequestBody DomesticStockDto domesticStockDto) {
        Map<String, Object> programTradeEstimateMap = new HashMap<>();

        try {
            String apiUrl = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/program-trade-by-stock";
            String tr_id = "FHPPG04650100";
            String custtype = "P";
            String param1 = basicStockId;
            if(domesticStockDto.getStockId() != null && domesticStockDto.getStockId() != "") {
                param1 = domesticStockDto.getStockId();
            }

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

    //TODO: API값 순서 문제로 인해 기업별 매수매도량 분석 부분 남겨둠
    @RequestMapping("/api/member-buy-sell-company")
    public Map<String, Object> MemberBuySellCompanySearch(@RequestBody DomesticStockDto domesticStockDto) {
        Map<String, Object> memberBuySellCompanySearchMap = new HashMap<>();

        try {
            String apiUrl = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-member";
            String tr_id = "FHKST01010600";
            String param1 = "J";
            String param2 = basicStockId;
            if(domesticStockDto.getStockId() != null && domesticStockDto.getStockId() != "") {
                param2 = domesticStockDto.getStockId();
            }

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

    @RequestMapping("/api/stock_chart_day")
    public Map<String, Object> StockChartDaySearch(@RequestBody DomesticStockDto domesticStockDto) {
        Map<String, Object> stockChartDaySearchMap = new HashMap<>();
        try {
            String apiUrl = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-daily-price";
            String tr_id = "FHKST01010400";
            String param1 = "J";
            String param2 = basicStockId;
            if(domesticStockDto.getStockId() != null && domesticStockDto.getStockId() != "") {
                param2 = domesticStockDto.getStockId();
            }
            String param3 = "D";
            String param4 = "0";

            URL url = new URL(apiUrl + "?FID_COND_MRKT_DIV_CODE=" + param1
                    + "&FID_INPUT_ISCD=" + param2
                    + "&FID_PERIOD_DIV_CODE=" + param3
                    + "&FID_ORG_ADJ_PRC=" + param4
            );

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
                stockChartDaySearchMap.put("content_type", content_type);
                stockChartDaySearchMap.put("tr_id", trid);
                stockChartDaySearchMap.put("tr_cont", tr_cont);
                stockChartDaySearchMap.put("gt_uid", gt_uid);
                stockChartDaySearchMap.put("response", response.toString());
            } else {
                System.out.println("HTTP Request Failed with Response Code: " + responseCode);
            }
            System.out.println("StockChartDaySearchMap : " + stockChartDaySearchMap);
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stockChartDaySearchMap;
    }

    @RequestMapping("/api/stock_chart_week")
    public Map<String, Object> StockChartWeekSearch(@RequestBody DomesticStockDto domesticStockDto) {
        Map<String, Object> stockChartDaySearchMap = new HashMap<>();
        try {
            String apiUrl = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-daily-price";
            String tr_id = "FHKST01010400";
            String param1 = "J";
            String param2 = basicStockId;
            if(domesticStockDto.getStockId() != null && domesticStockDto.getStockId() != "") {
                param2 = domesticStockDto.getStockId();
            }
            String param3 = "W";
            String param4 = "0";

            URL url = new URL(apiUrl + "?FID_COND_MRKT_DIV_CODE=" + param1
                    + "&FID_INPUT_ISCD=" + param2
                    + "&FID_PERIOD_DIV_CODE=" + param3
                    + "&FID_ORG_ADJ_PRC=" + param4
            );

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
                stockChartDaySearchMap.put("content_type", content_type);
                stockChartDaySearchMap.put("tr_id", trid);
                stockChartDaySearchMap.put("tr_cont", tr_cont);
                stockChartDaySearchMap.put("gt_uid", gt_uid);
                stockChartDaySearchMap.put("response", response.toString());
            } else {
                System.out.println("HTTP Request Failed with Response Code: " + responseCode);
            }
            System.out.println("StockChartWeekSearchMap : " + stockChartDaySearchMap);
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stockChartDaySearchMap;
    }

    @RequestMapping("/api/stock_chart_month")
    public Map<String, Object> StockChartMonthSearch(@RequestBody DomesticStockDto domesticStockDto) {
        Map<String, Object> stockChartDaySearchMap = new HashMap<>();
        try {
            String apiUrl = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-daily-price";
            String tr_id = "FHKST01010400";
            String param1 = "J";
            String param2 = basicStockId;
            if(domesticStockDto.getStockId() != null && domesticStockDto.getStockId() != "") {
                param2 = domesticStockDto.getStockId();
            }
            String param3 = "M";
            String param4 = "0";

            URL url = new URL(apiUrl + "?FID_COND_MRKT_DIV_CODE=" + param1
                    + "&FID_INPUT_ISCD=" + param2
                    + "&FID_PERIOD_DIV_CODE=" + param3
                    + "&FID_ORG_ADJ_PRC=" + param4
            );

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
                stockChartDaySearchMap.put("content_type", content_type);
                stockChartDaySearchMap.put("tr_id", trid);
                stockChartDaySearchMap.put("tr_cont", tr_cont);
                stockChartDaySearchMap.put("gt_uid", gt_uid);
                stockChartDaySearchMap.put("response", response.toString());
            } else {
                System.out.println("HTTP Request Failed with Response Code: " + responseCode);
            }
            System.out.println("StockChartMonthSearchMap : " + stockChartDaySearchMap);
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stockChartDaySearchMap;
    }
}

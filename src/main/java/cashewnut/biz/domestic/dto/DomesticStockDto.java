package cashewnut.biz.domestic.dto;

import lombok.Data;

@Data
public class DomesticStockDto {
    private String stockId;
    private String ymd;

    public DomesticStockDto() {
        // 기본생성자
    };
    public DomesticStockDto(String stockId) {
        this.stockId = stockId;
    }

    public DomesticStockDto(String stockId, String ymd) {
        this.stockId = stockId;
        this.ymd = ymd;
    }

    @Override
    public String toString() {
        return "DomesticStockDto{" +
                "stockId='" + stockId + '\'' +
                ", ymd='" + ymd + '\'' +
                '}';
    }
}

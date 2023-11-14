package cashewnut.biz.domestic.dto;

import lombok.Data;

@Data
public class DomesticStockDto {
    private String stockId;

    public DomesticStockDto() {
        // 기본생성자
    };
    public DomesticStockDto(String stockId) {
        this.stockId = stockId;
    }
    @Override
    public String toString() {
        return "DomesticStockDto{" +
                "stockId='" + stockId + '\'' +
                '}';
    }
}

package cashewnut.biz.home.dto;

import lombok.Data;

@Data
public class ThemaTotalIndexDto {
    private String fidInputIscd; // 종목코드
    private String fidPeriodDivCode; // 조회 D:일봉 W:주봉, M:월봉, Y:년봉

    public ThemaTotalIndexDto() {
        // 기본생성자
    }
    public ThemaTotalIndexDto(String fidInputIscd) {
        this.fidInputIscd = fidInputIscd;
    }
    public ThemaTotalIndexDto(String fidInputIscd, String fidPeriodDivCode) {
        this.fidInputIscd = fidInputIscd;
        this.fidPeriodDivCode = fidPeriodDivCode;
    }
    @Override
    public String toString() {
        return "ThemaTotalIndexDto{" +
                "fidInputIscd='" + fidInputIscd + '\'' +
                ", fidPeriodDivCode='" + fidPeriodDivCode + '\'' +
                '}';
    }
}

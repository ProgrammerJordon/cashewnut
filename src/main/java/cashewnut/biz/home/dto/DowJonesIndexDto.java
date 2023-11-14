package cashewnut.biz.home.dto;

import lombok.Data;

@Data
public class DowJonesIndexDto {
    private String fidInputIscd; // 종목코드
    public DowJonesIndexDto(String fidInputIscd) {
        this.fidInputIscd = fidInputIscd;
    }
    @Override
    public String toString() {
        return "DowJonesIndexDto{" +
                "fidInputIscd='" + fidInputIscd + '\'' +
                '}';
    }
}

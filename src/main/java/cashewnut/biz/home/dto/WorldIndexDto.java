package cashewnut.biz.home.dto;

import lombok.Data;

@Data
public class WorldIndexDto {
    private String fidInputIscd; // 종목코드

    public WorldIndexDto() {
        // 기본생성자
    };
    public WorldIndexDto(String fidInputIscd) {
        this.fidInputIscd = fidInputIscd;
    }
    @Override
    public String toString() {
        return "DowJonesIndexDto{" +
                "fidInputIscd='" + fidInputIscd + '\'' +
                '}';
    }
}

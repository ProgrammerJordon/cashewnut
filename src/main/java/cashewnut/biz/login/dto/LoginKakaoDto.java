package cashewnut.biz.login.dto;

import lombok.Data;

@Data
public class LoginKakaoDto {

    private String id;
    private String connected_at;
    private String kakao_account;
    private String properties;

    public LoginKakaoDto() {
    }

    public LoginKakaoDto(String id, String connected_at, String kakao_account, String properties) {
        this.id = id;
        this.connected_at = connected_at;
        this.kakao_account = kakao_account;
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "LoginKakaoDto{" +
                "id='" + id + '\'' +
                ", connected_at='" + connected_at + '\'' +
                ", kakao_account='" + kakao_account + '\'' +
                ", properties='" + properties + '\'' +
                '}';
    }
}

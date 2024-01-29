package cashewnut.biz.login.dto;

import lombok.Data;

@Data
public class LoginGoogleDto {

    private String id;
    private String name;
    private String imageUrl;
    private String email;

    public LoginGoogleDto() {

    }

    public LoginGoogleDto(String id, String name, String imageUrl, String email) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.email = email;
    }
}

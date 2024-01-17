package cashewnut.biz.login.dto;

import lombok.Data;

@Data
public class LoginKakaoDto {

    private String id;
    private String connected_at;
    private String email;
    private String age_range;
    private String gender;
    private String profile_nickname;
    private String birthday;
    private String birthday_type;
    private String profile_image_url;

    public LoginKakaoDto() {
    }

    public LoginKakaoDto(String id, String connected_at, String email, String age_range, String gender, String profile_nickname, String birthday, String birthday_type, String profile_image_url) {
        this.id = id;
        this.connected_at = connected_at;
        this.email = email;
        this.age_range = age_range;
        this.gender = gender;
        this.profile_nickname = profile_nickname;
        this.birthday = birthday;
        this.birthday_type = birthday_type;
        this.profile_image_url = profile_image_url;
    }
}

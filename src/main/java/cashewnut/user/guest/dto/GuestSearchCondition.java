package cashewnut.user.guest.dto;

import lombok.Data;

@Data
public class GuestSearchCondition {

    private String userName;
    private String teamName;
    private Integer ageGoe;
    private Integer ageLoe;
}

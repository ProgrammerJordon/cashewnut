package cashewnut.user.guest.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class GuestTeamDto {

    private Long guestId;
    private String userName;
    private int age;
    private Long teamId;
    private String teamName;

    @QueryProjection
    public GuestTeamDto(Long guestId, String userName, int age, Long teamId, String teamName) {
        this.guestId = guestId;
        this.userName = userName;
        this.age = age;
        this.teamId = teamId;
        this.teamName = teamName;
    }
}

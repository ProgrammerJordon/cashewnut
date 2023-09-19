package cashewnut.membership.dto;

import cashewnut.membership.entity.Team;
import lombok.Data;

@Data
public class MembershipDto {

    private Long id;
    private String userName;
    private String teamName;

    public MembershipDto(Long id, String userName, String teamName) {
        this.id = id;
        this.userName = userName;
        this.teamName = teamName;
    }
}

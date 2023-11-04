package cashewnut.user.membership.dto;

import cashewnut.user.membership.domain.Membership;
import lombok.Data;

@Data
public class MembershipDto {

    private Long id;
    private String userName;
    private String teamName;

    public MembershipDto() {
    }

    public MembershipDto(Long id, String userName, String teamName) {
        this.id = id;
        this.userName = userName;
        this.teamName = teamName;
    }

    public MembershipDto(Membership membership) {
        this.id = membership.getId();
        this.userName = membership.getUserName();
    }
}

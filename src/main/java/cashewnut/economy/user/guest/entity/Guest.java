package cashewnut.economy.user.guest.entity;

import cashewnut.economy.common.Track;
import cashewnut.economy.user.membership.entity.Team;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "userName", "age"})
public class Guest extends Track {

    @Id @GeneratedValue
    @Column(name ="guest_id")
    private Long id;

    private String userName;
    private int age;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Guest(String userName) {
        this.userName = userName;
    }

    public Guest(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public Guest(String userName, int age, Team team) {
        this.userName = userName;
        this.age = age;
        if(team != null) {
            changeTeam(team);
        }
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getGuests().add(this);
    }
}

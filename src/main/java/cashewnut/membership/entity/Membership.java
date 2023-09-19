package cashewnut.membership.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "userName", "age"})
@NamedQuery(
        name = "Membership.findByUserName",
        query = "select m from Membership m where userName = :userName"
)

public class Membership {

    @Id @GeneratedValue
    @Column(name ="membership_id")
    private Long id;

    private String userName;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Membership(String userName) {
        this.userName = userName;
    }

    public Membership(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public Membership(String membership, int age, Team team) {
        this.userName = membership;
        this.age = age;
        if(team != null) {
            changeTeam(team);
        }
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMemberShips().add(this);
    }
}

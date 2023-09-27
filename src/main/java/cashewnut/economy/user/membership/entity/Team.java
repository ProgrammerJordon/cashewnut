package cashewnut.economy.user.membership.entity;

import cashewnut.economy.common.Track;
import cashewnut.economy.user.guest.entity.Guest;
import cashewnut.economy.user.master.entity.Master;
import cashewnut.economy.user.member.domain.Member;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class Team extends Track {

    @Id @GeneratedValue
    @Column(name = "team_id")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "team")
    private List<Membership> MemberShips = new ArrayList<>();

    @OneToMany(mappedBy = "team")
    private List<Member> Members = new ArrayList<>();

    @OneToMany(mappedBy = "team")
    private List<Guest> Guests = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "master_id")
    private Master master;

    public Team(String name) {
        this.name = name;
    }
}

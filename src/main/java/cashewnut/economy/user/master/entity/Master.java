package cashewnut.economy.user.master.entity;

import cashewnut.economy.board.faq.Faq;
import cashewnut.economy.board.notice.Notice;
import cashewnut.economy.board.qna.Qna;
import cashewnut.economy.common.Track;
import cashewnut.economy.user.membership.entity.Team;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Master extends Track {

    @Id
    @GeneratedValue
    @Column(name = "master_id")
    private Long id;

    @OneToMany(mappedBy = "master")
    private List<Team> teamList = new ArrayList<>();

    @OneToMany(mappedBy = "master")
    private List<Notice> noticeList = new ArrayList<>();

    @OneToMany(mappedBy = "master")
    private List<Qna> qnaList = new ArrayList<>();

    @OneToMany(mappedBy = "master")
    private List<Faq> faqList = new ArrayList<>();


}

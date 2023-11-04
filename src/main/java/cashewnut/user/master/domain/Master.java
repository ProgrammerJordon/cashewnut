package cashewnut.user.master.domain;

import cashewnut.common.board.faq.Faq;
import cashewnut.common.board.notice.Notice;
import cashewnut.common.board.qna.Qna;
import cashewnut.common.util.Track;
import cashewnut.user.membership.domain.Team;
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

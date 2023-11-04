package cashewnut.common.board.qna;

import cashewnut.common.util.Track;
import cashewnut.user.master.domain.Master;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Qna extends Track {

    @Id
    @GeneratedValue
    @Column(name = "qna_id")
    private Long id;

    private String title;

    private String contents;

    private int viewCount;

    @OneToMany(mappedBy = "qna")
    private List<QnaReply> qnaReplyList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "master_id")
    private Master master;
}

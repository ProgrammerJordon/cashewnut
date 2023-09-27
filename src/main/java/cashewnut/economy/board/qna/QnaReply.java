package cashewnut.economy.board.qna;

import cashewnut.economy.common.Track;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class QnaReply extends Track {

    @Id @GeneratedValue
    @Column(name = "qnareply_id")
    private Long id;

    private String replyContents;

    private int viewCount;

    @ManyToOne
    @JoinColumn(name = "qna_id")
    private Qna qna;

}
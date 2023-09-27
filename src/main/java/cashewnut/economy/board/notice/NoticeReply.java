package cashewnut.economy.board.notice;

import cashewnut.economy.common.Track;
import cashewnut.economy.user.master.entity.Master;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class NoticeReply extends Track {

    @Id @GeneratedValue
    @Column(name="noticeReply_id")
    private Long id;

    private String replyContents;

    private int viewCount;

    @ManyToOne
    @JoinColumn(name = "notice_id")
    private Notice notice;

}
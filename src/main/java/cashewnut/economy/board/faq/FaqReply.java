package cashewnut.economy.board.faq;

import cashewnut.economy.common.Track;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class FaqReply extends Track {

    @Id @GeneratedValue
    private Long id;

    private String replyContents;

    private int viewCount;

    @ManyToOne
    @JoinColumn(name = "faq_id")
    private Faq faq;
}

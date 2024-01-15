package cashewnut.biz.cashflow.domain;

import cashewnut.common.util.Track;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table
public class CashflowBoard extends Track {

    @Id
    @GeneratedValue
    @Column(name ="cashflowBoard_id")
    private Long id;

    private String title;

    private String content;

    @OneToMany(mappedBy = "cashflowBoard", fetch = FetchType.LAZY)
    private List<CashflowBoardReply> cashflowBoardReplyList = new ArrayList<>();

    public CashflowBoard() {
    }

    @Override
    public String toString() {
        return "CashflowBoard{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", cashflowBoardReplyList=" + cashflowBoardReplyList +
                '}';
    }

    public CashflowBoard(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}

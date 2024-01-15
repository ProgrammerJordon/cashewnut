package cashewnut.biz.cashflow.domain;

import cashewnut.common.util.Track;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table
public class CashflowBoardReply extends Track {

    @Id
    @GeneratedValue
    @Column(name = "cashflow_board_reply_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cashflowBoard_id")
    private CashflowBoard cashflowBoard;

    private String content;

    public CashflowBoardReply() {

    }

    public CashflowBoardReply(Long id, CashflowBoard cashflowBoard, String content) {
        this.id = id;
        this.cashflowBoard = cashflowBoard;
        this.content = content;
    }

    @Override
    public String toString() {
        return "CashflowBoardReply{" +
                "id=" + id +
                ", cashflowBoard=" + cashflowBoard +
                ", content='" + content + '\'' +
                '}';
    }
}

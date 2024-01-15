package cashewnut.biz.cashflow.dto;

import cashewnut.biz.cashflow.domain.CashflowBoard;
import cashewnut.common.util.Track;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CashflowBoardDto{

    private Long id;
    private String title;
    private String content;

    private List<CashflowBoardDto> cashflowBoardList = new ArrayList<>();

    @Override
    public String toString() {
        return "CashflowBoardDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", cashflowBoardList=" + cashflowBoardList +
                '}';
    }
}

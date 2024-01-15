package cashewnut.biz.cashflow.dto;

import cashewnut.biz.cashflow.domain.CashflowBoard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CashflowBoardReplyDto {

    private Long id;
    private String content;

    private CashflowBoard cashflowBoard;

    @Override
    public String toString() {
        return "CashflowBoardReplyDto{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", cashflowBoard=" + cashflowBoard +
                '}';
    }
}

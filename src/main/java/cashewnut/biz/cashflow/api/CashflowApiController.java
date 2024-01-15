package cashewnut.biz.cashflow.api;

import cashewnut.biz.cashflow.domain.CashflowBoard;
import cashewnut.biz.cashflow.domain.CashflowBoardReply;
import cashewnut.biz.cashflow.dto.CashflowBoardDto;
import cashewnut.biz.cashflow.dto.CashflowBoardReplyDto;
import cashewnut.biz.cashflow.service.CashflowService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CashflowApiController {

    private final CashflowService cashflowService;

    @PostMapping("/cashflow/insertCashflowBoard")
    public void save(@RequestBody CashflowBoardDto cashflowBoardDto) throws Exception {
        CashflowBoard cashflowBoard = new CashflowBoard();
        cashflowBoard.setTitle(cashflowBoardDto.getTitle());
        cashflowBoard.setContent(cashflowBoardDto.getContent());
        cashflowService.save(cashflowBoard);
    }

    @GetMapping("/cashflow/selectCashflowBoardList")
    @ResponseBody
    public List<CashflowBoard> findAll() throws Exception {
        List<CashflowBoard> list = cashflowService.findAll();
        System.out.println("list : " + list);
        return list;
    }

    @PostMapping("/cashflow/deleteCashflowBoard")
    public void delete(@RequestBody CashflowBoardDto cashflowBoardDto) throws Exception {
        cashflowService.delete(cashflowBoardDto);
    }

    @PostMapping("/cashflow/selectCashflowBoardDetail")
    public CashflowBoard selectOne(@RequestBody CashflowBoardDto cashflowBoardDto) throws Exception {
        CashflowBoard cashflowBoard = new CashflowBoard();
        cashflowBoard.setId(cashflowBoardDto.getId());
        return cashflowService.selectOne(cashflowBoard);

    }

    @PostMapping("/cashflow/insertCashflowBoardReply")
    public void saveReply(@RequestBody CashflowBoardReplyDto cashflowBoardReplyDto) throws Exception {
        CashflowBoardReply cashflowBoardReply = new CashflowBoardReply();
        cashflowBoardReply.setId(cashflowBoardReplyDto.getId());
        cashflowBoardReply.setContent(cashflowBoardReplyDto.getContent());
        cashflowService.saveReply(cashflowBoardReply);
    }

    @PostMapping("/cashflow/selelctCashflowBoardReplyList")
    public List<CashflowBoardReply> cashflowBoardReplyList(@RequestBody CashflowBoardReplyDto cashflowBoardReplyDto) throws Exception {
        CashflowBoardReply cashflowBoardReply = new CashflowBoardReply();
        cashflowBoardReply.setId(cashflowBoardReplyDto.getId());
        return cashflowService.findAllReply(cashflowBoardReply);
    }

}
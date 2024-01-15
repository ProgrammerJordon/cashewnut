package cashewnut.biz.cashflow.service;

import cashewnut.biz.cashflow.domain.CashflowBoard;
import cashewnut.biz.cashflow.domain.CashflowBoardReply;
import cashewnut.biz.cashflow.dto.CashflowBoardDto;

import java.util.List;

public interface CashflowService {

    void save(CashflowBoard cashflowBoard) throws Exception;
    List<CashflowBoard> findAll() throws Exception;

    CashflowBoard selectOne(CashflowBoard cashflowBoard) throws Exception;

    void delete(CashflowBoardDto cashflowBoard) throws Exception;

    CashflowBoard find(Long id) throws Exception;

    void saveReply(CashflowBoardReply cashflowBoardReply) throws Exception;

    List<CashflowBoardReply> findAllReply(CashflowBoardReply cashflowBoardReply) throws Exception;
}

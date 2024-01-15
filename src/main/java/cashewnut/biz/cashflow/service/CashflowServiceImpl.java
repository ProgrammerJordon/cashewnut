package cashewnut.biz.cashflow.service;

import cashewnut.biz.cashflow.domain.CashflowBoard;
import cashewnut.biz.cashflow.domain.CashflowBoardReply;
import cashewnut.biz.cashflow.dto.CashflowBoardDto;
import cashewnut.biz.cashflow.repository.CashflowBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CashflowServiceImpl implements CashflowService {

    private final CashflowBoardRepository cashflowBoardRepository;

    @Override
    public void save(CashflowBoard cashflowBoard) throws Exception {
        cashflowBoardRepository.save(cashflowBoard);
    }

    @Override
    public List<CashflowBoard> findAll() throws Exception {
        List<CashflowBoard> cashflowBoardList = cashflowBoardRepository.findAll();
        return cashflowBoardList;
    }

    @Override
    public CashflowBoard selectOne(CashflowBoard cashflowBoard) throws Exception {
        return cashflowBoardRepository.selectOne(cashflowBoard);
    }

    @Override
    public void delete(CashflowBoardDto cashflowBoard) throws Exception {
        CashflowBoard result = cashflowBoardRepository.find(cashflowBoard.getId());
        cashflowBoardRepository.delete(result);
    }

    @Override
    public CashflowBoard find(Long id) throws Exception {
        return cashflowBoardRepository.find(id);
    }

    @Override
    public void saveReply(CashflowBoardReply cashflowBoardReply) throws Exception {

        CashflowBoard cashflowBoard = cashflowBoardRepository.find(cashflowBoardReply.getId());
        CashflowBoardReply data = new CashflowBoardReply();
        data.setContent(cashflowBoardReply.getContent());
        data.setCashflowBoard(cashflowBoard);
        cashflowBoardRepository.saveReply(data);
    }

    @Override
    public List<CashflowBoardReply> findAllReply(CashflowBoardReply cashflowBoardReply) throws Exception {
        return cashflowBoardRepository.findAllReply(cashflowBoardReply);
    }
}

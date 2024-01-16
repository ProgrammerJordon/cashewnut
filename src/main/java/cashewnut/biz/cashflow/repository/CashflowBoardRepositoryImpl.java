package cashewnut.biz.cashflow.repository;

import cashewnut.biz.cashflow.domain.CashflowBoard;
import cashewnut.biz.cashflow.domain.CashflowBoardReply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CashflowBoardRepositoryImpl implements CashflowBoardRepository {

    private final EntityManager em;

    @Override
    public void save(CashflowBoard cashflowBoard) throws Exception {
        em.persist(cashflowBoard);
    }

    @Override
    public List<CashflowBoard> findAll() throws Exception {
        return em.createQuery("select cb from CashflowBoard cb", CashflowBoard.class)
                .getResultList();
    }

    @Override
    public CashflowBoard selectOne(CashflowBoard cashflowBoard) throws Exception {
        return (CashflowBoard) em.createQuery("select cb from CashflowBoard cb where cb.id = :id")
                .setParameter("id", cashflowBoard.getId())
                .getSingleResult();
    }

    @Override
    public CashflowBoard find(Long id) throws Exception {
        return em.find(CashflowBoard.class, id);
    }

    @Override
    public void delete(CashflowBoard cashflowBoard) throws Exception {
        em.remove(cashflowBoard);
    }

    @Override
    public void saveReply(CashflowBoardReply cashflowBoardReply) throws Exception {
        em.persist(cashflowBoardReply);
    }

    @Override
    public List<CashflowBoardReply> findAllReply(CashflowBoardReply cashflowBoardReply) throws Exception {
        return em.createQuery("select cbr from CashflowBoardReply cbr where cbr.cashflowBoard.id = :id")
                .setParameter("id", cashflowBoardReply.getId())
                .getResultList();
    }
}

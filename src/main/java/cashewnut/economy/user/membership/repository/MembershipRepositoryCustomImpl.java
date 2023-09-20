package cashewnut.economy.user.membership.repository;

import cashewnut.economy.user.membership.entity.Membership;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class MembershipRepositoryCustomImpl implements  MembershipRepositoryCustom{

    private final EntityManager em;

    @Override
    public List<Membership> findMembershipCustom() {
        return em.createQuery("select m from Membership m")
                .getResultList();
    }
}

package cashewnut.economy.user.membership.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
@Rollback(value = true)
public class MembershipTest {

    @PersistenceContext
    EntityManager em;

    @Test
    public void 맴버쉽엔티티테스트() throws Exception {
        // given
        Team teamA = new Team("TeamA");
        Team teamB = new Team("TeamB");

        em.persist(teamA);
        em.persist(teamB);

        Membership membership1 = new Membership("Membership1", 10, teamA);
        Membership membership2 = new Membership("Membership2", 20, teamA);
        Membership membership3 = new Membership("Membership3", 30, teamB);
        Membership membership4 = new Membership("Membership4", 40, teamB);
        //저장
        em.persist(membership1);
        em.persist(membership2);
        em.persist(membership3);
        em.persist(membership4);
        //초기화
        em.flush();
        em.clear();
        //확인
        List<Membership> memberships =
                em.createQuery("select ms from Membership ms", Membership.class)
                        .getResultList();
        for (Membership membership : memberships) {
            System.out.println("membership = " + membership);
            System.out.println("-> membership.Team = " + membership.getTeam());

        }
        // when

        // then
    }
}
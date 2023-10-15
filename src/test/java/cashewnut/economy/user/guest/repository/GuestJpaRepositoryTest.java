package cashewnut.economy.user.guest.repository;

import cashewnut.economy.user.guest.dto.GuestSearchCondition;
import cashewnut.economy.user.guest.dto.GuestTeamDto;
import cashewnut.economy.user.guest.entity.Guest;
import cashewnut.economy.user.membership.entity.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GuestJpaRepositoryTest {

    @Autowired
    private EntityManager em;
    @Autowired
    private GuestJpaRepository guestJpaRepository;
    private JPAQueryFactory queryFactory;
    @Test
    public void 기초테스트() throws Exception {
        // given
        Guest guest = new Guest("guest1", 10);
        guestJpaRepository.save(guest);
        // when
        Guest findGuest = guestJpaRepository.findById(guest.getId()).get();
        // then
        Assertions.assertThat(findGuest).isEqualTo(guest);

        List<Guest> result = guestJpaRepository.findAll();
        Assertions.assertThat(result).containsExactly(guest);

        List<Guest> result2 = guestJpaRepository.findByUserName("guest1");
        Assertions.assertThat(result2).containsExactly(guest);
    }

    @Test
    public void searchByBuilder() throws Exception {
        // given
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        Guest guest1 = new Guest("guest1", 10, teamA);
        Guest guest2 = new Guest("guest2", 20, teamA);
        Guest guest3 = new Guest("guest3", 30, teamB);
        Guest guest4 = new Guest("guest4", 40, teamB);
        em.persist(guest1);
        em.persist(guest2);
        em.persist(guest3);
        em.persist(guest4);
        // when
        GuestSearchCondition condition = new GuestSearchCondition();
        condition.setAgeGoe(35);
        condition.setAgeLoe(40);
        condition.setTeamName("teamB");

        List<GuestTeamDto> result = guestJpaRepository.searchByBuilder(condition);
        // then
        Assertions.assertThat(result).extracting("userName").containsExactly("guest4");
    }

    @Test
    public void searchByBuilder2() throws Exception {
        // given
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        Guest guest1 = new Guest("guest1", 10, teamA);
        Guest guest2 = new Guest("guest2", 20, teamA);
        Guest guest3 = new Guest("guest3", 30, teamB);
        Guest guest4 = new Guest("guest4", 40, teamB);
        em.persist(guest1);
        em.persist(guest2);
        em.persist(guest3);
        em.persist(guest4);
        // when
        GuestSearchCondition condition = new GuestSearchCondition();
        condition.setAgeGoe(35);
        condition.setAgeLoe(40);
        condition.setTeamName("teamB");

        List<GuestTeamDto> result = guestJpaRepository.searchByBuilder2(condition);
        // then
        Assertions.assertThat(result).extracting("userName").containsExactly("guest4");
    }
}
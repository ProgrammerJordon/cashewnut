package cashewnut.economy.user.guest.entity;

import cashewnut.economy.user.membership.entity.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static cashewnut.economy.user.guest.entity.QGuest.guest;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GuestTest {

    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;

    /**
     * 기본 설정 및 상태 초기화
     * Junit4는 @Before
     * Junit5는 @BeforeEach
     * @throws Exception
     */
    @Before
    public void initGuestDB() throws Exception {
        queryFactory = new JPAQueryFactory(em);
        // given
        Team teamA = new Team("TeamA");
        Team teamB = new Team("TeamB");
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
    }

    @Test
    public void QueryDSL오퍼레이션테스트() throws Exception {

        // given
        Guest findGuest = queryFactory
                .select(guest)
                .from(guest)
                .where(
                        guest.userName.eq("guest1"),
                        guest.age.eq(10)
                )
                .fetchOne();
        // when
        assertThat(findGuest.getUserName()).isEqualTo("guest1");
        // then
    }
    @Test
    public void QueryDSL조회테스트() throws Exception {
        // given
        Guest findGuest = queryFactory
                .selectFrom(guest)
                .where(
                        guest.userName.eq("guest1")
                                .and(guest.age.eq(10))
                )
                .fetchOne();
        // when
        assertThat(findGuest.getUserName()).isEqualTo("guest1");
        assertThat(findGuest.getAge()).isEqualTo(10);
        // then
    }

    @Test
    public void QueryDSL조회및파리미터테스트() throws Exception {
        // given
        Guest findGuest = queryFactory
                .selectFrom(guest)
                .where(
                        // .and() 대신 , 를 이용가능
                        guest.userName.eq("guest1"),
                                (guest.age.eq(10))
                )
                .fetchOne();
        // when
        assertThat(findGuest.getUserName()).isEqualTo("guest1");
        assertThat(findGuest.getAge()).isEqualTo(10);
        // then
    }
}
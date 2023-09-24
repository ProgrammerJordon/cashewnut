package cashewnut.economy.user.guest.entity;

import cashewnut.economy.user.membership.entity.Team;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
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

import java.util.List;

import static cashewnut.economy.user.guest.entity.QGuest.guest;
import static cashewnut.economy.user.membership.entity.QTeam.team;
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
     *
     * @throws Exception
     */
    @Before
    public void initGuestDB() throws Exception {
        queryFactory = new JPAQueryFactory(em);
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

    @Test
    public void 리스트조회() throws Exception {
        // given
        /**
         * 엔티티관련 DB 전체 리스트 조회
         */
        List<Guest> fetch = queryFactory
                .selectFrom(guest)
                .fetch();
        /**
         * 검색한 하나의 데이터 객체 조회
         */
        Guest fetchOne = queryFactory
                .selectFrom(guest)
                .fetchOne();
        /**
         * RowNum으로 감싼 첫번째 객체 데이터만 출력 (limit())
         */
        Guest fetchFirst = queryFactory
                .selectFrom(guest)
                .fetchFirst();

        /**
         * Wrapper로 감싼 List 반환 - DTO 개념
         */
        QueryResults<Guest> fetchResults = queryFactory
                .selectFrom(guest)
                .fetchResults();
        fetchResults.getTotal();
        List<Guest> guestList = fetchResults.getResults();

        /**
         * 총갯수 조회
         */
        long fetchCount = queryFactory
                .selectFrom(guest)
                .fetchCount();
    }

    @Test
    public void 정렬_Sorting() throws Exception {
        // given
        em.persist(new Guest(null, 100));
        em.persist(new Guest("guest5", 100));
        em.persist(new Guest("guest6", 100));
        // when
        List<Guest> result = queryFactory
                .selectFrom(guest)
                .where(guest.age.eq(100))
                .orderBy(guest.age.desc(), guest.userName.asc().nullsLast())
                .fetch();
        // then
        Guest guest5 = result.get(0);
        Guest guest6 = result.get(1);
        Guest guestNull = result.get(2);

        assertThat(guest5.getUserName()).isEqualTo("guest5");
        assertThat(guest6.getUserName()).isEqualTo("guest6");
        assertThat(guestNull.getUserName()).isNull();
    }

    @Test
    public void 페이징() throws Exception {
        // given
        List<Guest> result = queryFactory
                .selectFrom(guest)
                .orderBy(guest.userName.desc())
                .offset(1)
                .limit(2)
                .fetch();
        // when
        assertThat(result.size()).isEqualTo(2);
        // then
    }

    @Test
    public void 전체페이징() throws Exception {
        // given
        QueryResults<Guest> fetchResults = queryFactory
                .selectFrom(guest)
                .orderBy(guest.userName.desc())
                .offset(1)
                .limit(2)
                .fetchResults();
        /**
         * fetResults.getResult를 뽑아쓰거나 그대로 바인딩해서 사용
         */
        List<Guest> results = fetchResults.getResults();
        // when
        assertThat(fetchResults.getTotal()).isEqualTo(4);
        assertThat(fetchResults.getLimit()).isEqualTo(2);
        assertThat(fetchResults.getOffset()).isEqualTo(1);
        assertThat(fetchResults.getResults().size()).isEqualTo(2);
        assertThat(results.size()).isEqualTo(2);
        // then
    }

    @Test
    public void 집합() throws Exception {
        // given
        List<Tuple> result = queryFactory
                .select(
                        guest.count(),
                        guest.age.sum(),
                        guest.age.avg(),
                        guest.age.max(),
                        guest.age.min()
                )
                .from(guest)
                .fetch();
        // when
        Tuple tuple = result.get(0);
        // then
        assertThat(tuple.get(guest.count())).isEqualTo(4);
        assertThat(tuple.get(guest.age.sum())).isEqualTo(100);
        assertThat(tuple.get(guest.age.avg())).isEqualTo(25);
        assertThat(tuple.get(guest.age.max())).isEqualTo(40);
        assertThat(tuple.get(guest.age.min())).isEqualTo(10);
    }

    /**
     * 각팀의 이름과 평균연령을 구함
     * @throws Exception
     */
    @Test
    public void GroupBy() throws Exception {
        // given
        List<Tuple> result = queryFactory.select(team.name, guest.age.avg())
                .from(guest)
                .join(guest.team, team)
                .groupBy(team.name)
                .fetch();
        // when
        Tuple teamA = result.get(0);
        Tuple teamB = result.get(1);
        // then
        assertThat(teamA.get(team.name)).isEqualTo("teamA");
        assertThat(teamA.get(guest.age.avg())).isEqualTo(15); // 10 + 20 = 15

        assertThat(teamB.get(team.name)).isEqualTo("teamB");
        assertThat(teamB.get(guest.age.avg())).isEqualTo(35); // 30 + 40 = 35
    }

    /**
     * teamA에 속한 모든 회원
     *
     * @throws Exception
     */
    @Test
    public void 조인() throws Exception {
        // given
        List<Guest> result = queryFactory
                .selectFrom(guest)
                .join(guest.team, team)
                .where(team.name.eq("teamA"))
                .fetch();
        // when

        // then
        assertThat(result)
                .extracting("userName")
                .containsExactly("guest1", "guest2");
    }

    /**
     * 연관관계가 없어도 조인이 가능함
     * 단, 연관관계가 없음으로 직접적인 외부연결(Left, Outtr Join)은 불가능
     * ex) 회원의 이름과 팀이 이름이 동일한 회원 조회
     *
     * @throws Exception
     */
    @Test
    public void 세타조인() throws Exception {
        // given
        em.persist(new Guest("teamA"));
        em.persist(new Guest("teamB"));
        em.persist(new Guest("teamC"));
        // when
        List<Guest> result = queryFactory
                .select(guest)
                .from(guest, team)
                .where(guest.userName.eq(team.name))
                .fetch();
        // then
        assertThat(result)
                .extracting("userName")
                .containsExactly("teamA", "teamB");
    }

    /**
     * 세타조인 최적화를 위한 join과 on 절 사용
     * ex) 팀과 회원을 모두 세타조인하고, 팀이름이 teamA인 팀을 조회하고 회원은 모두 조회
     * JPQL : "select g, t from Guest g join g.team t on t.name='teamA'"
     *
     * @throws Exception
     */
    @Test
    public void 세타조인_on_필터링() throws Exception {
        // given
        List<Tuple> result = queryFactory
                .select(guest, team)
                .from(guest)
                .join(guest.team, team).on(team.name.eq("teamA"))
                .fetch();
        // when
        for (Tuple tuple : result) {
            System.out.println("tuple : " + tuple);
        }
        // then
    }

    @Test
    public void 엔티티외부조인_without_연관관계() throws Exception {
        // given
        em.persist(new Guest("teamA"));
        em.persist(new Guest("teamB"));
        em.persist(new Guest("teamC"));
        // when
        List<Tuple> result = queryFactory
                .select(guest, team)
                .from(guest, team)
                .join(team).on(guest.userName.eq(team.name))
                .fetch();
        // then
        for (Tuple tuple : result) {
            System.out.println("tuple : " + tuple);
        }
    }
}
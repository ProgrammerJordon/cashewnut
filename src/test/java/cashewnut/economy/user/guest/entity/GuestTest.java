package cashewnut.economy.user.guest.entity;

import cashewnut.economy.user.guest.dto.GuestDto;
import cashewnut.economy.user.guest.dto.QGuestDto;
import cashewnut.economy.user.guest.dto.UserDto;
import cashewnut.economy.user.membership.entity.Team;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.catalina.User;
import org.hibernate.criterion.Projection;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import java.util.List;

import static cashewnut.economy.user.guest.entity.QGuest.guest;
import static cashewnut.economy.user.membership.entity.QTeam.team;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GuestTest {

    @Autowired
    EntityManager em;

    @PersistenceUnit
    EntityManagerFactory emf;

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
                .where(guest.userName.eq("guest1"))
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
     *
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

    @Test
    public void NO_패치조인() throws Exception {

        // given
        em.flush();
        em.clear();
        // when
        Guest findGuset = queryFactory
                .selectFrom(guest)
                .where(guest.userName.eq("guset1"))
                .fetchOne();
        // then
        boolean loaded = emf.getPersistenceUnitUtil().isLoaded(findGuset.getTeam());
        assertThat(loaded).as("패치조인미적용").isFalse();
    }

    @Test
    public void 패치조인_적용() throws Exception {
        // given
        em.flush();
        em.clear();
        // when
        Guest findGuset = queryFactory
                .selectFrom(guest)
                .join(guest.team, team).fetchJoin()
                .where(guest.userName.eq("guest1"))
                .fetchOne();
        // then
        boolean loaded = emf.getPersistenceUnitUtil().isLoaded(findGuset.getTeam());
        assertThat(loaded).as("패치조인적용").isTrue();
    }

    @Test
    public void 서브쿼리() throws Exception {
        // given
        QGuest guestSub = new QGuest("guestSub");
        // when
        List<Guest> result = queryFactory
                .selectFrom(guest)
                .where(guest.age.eq(
                        JPAExpressions
                                .select(guestSub.age.max())
                                .from(guestSub)
                ))
                .fetch();
        // then
        assertThat(result)
                .extracting("age").containsExactly(40);
    }

    @Test
    public void 서브쿼리_평균() throws Exception {
        // given
        QGuest guestSub = new QGuest("guestSub");
        // when
        List<Guest> result = queryFactory
                .selectFrom(guest)
                .where(guest.age.goe(
                        JPAExpressions
                                .select(guestSub.age.avg())
                                .from(guestSub)
                ))
                .fetch();
        // then
        assertThat(result)
                .extracting("age").containsExactly(30,40);
    }

    @Test
    public void 서브쿼리_In() throws Exception {
        // given
        QGuest guestSub = new QGuest("guestSub");
        // when
        List<Guest> result = queryFactory
                .selectFrom(guest)
                .where(guest.age.in(
                        JPAExpressions
                                .select(guestSub.age)
                                .from(guestSub)
                                .where(guest.age.gt(10))
                ))
                .fetch();
        // then
        assertThat(result)
                .extracting("age").containsExactly(20, 30, 40);
    }

    @Test
    public void 서브쿼리_조회() throws Exception {
        // given
        QGuest guestSub = new QGuest("guestSub");
        // when
        List<Tuple> result = queryFactory
                .select(guest.userName,
                        JPAExpressions
                                .select(guestSub.age.avg())
                                .from(guestSub)
                )
                .from(guest)
                .fetch();
        // then
        for (Tuple tuple : result) {
            System.out.println("result : " + tuple);
        }
    }

    @Test
    public void case문() throws Exception {
        // given
        List<String> result = queryFactory
                .select(guest.age
                        .when(10).then("10살")
                        .when(20).then("20살")
                        .when(30).then("30살")
                        .when(40).then("30살")
                        .otherwise("노인")
                )
                .from(guest)
                .fetch();
        // when
        for (String s : result) {
            System.out.println("result : " + s);
        }
        // then
    }

    @Test
    public void case_builder() throws Exception {
        // given
        List<String> result = queryFactory
                .select(new CaseBuilder()
                        .when(guest.age.between(10, 20)).then("10~20")
                        .when(guest.age.between(21, 30)).then("21~30")
                        .otherwise("노인")
                )
                .from(guest)
                .fetch();
        // when
        for (String s : result) {
            System.out.println("result : " + s);
        }
        // then
    }

    @Test
    public void 상수() throws Exception {
        // given
        List<Tuple> result = queryFactory
                .select(guest.userName, Expressions.constant("A"))
                .from(guest)
                .fetch();
        // when
        for (Tuple tuple : result) {
            System.out.println("tuple : " + tuple);
        }
        // then
    }

    @Test
    public void 문자() throws Exception {
        // given
        List<String> result = queryFactory
                .select(guest.userName.concat("_").concat(guest.age.stringValue()))
                .from(guest)
                .where(guest.userName.eq("guest1"))
                .fetch();
        // when
        for (String s : result) {
            System.out.println("result : " + s);
        }
        // then
    }
    
    @Test
    public void 프로젝션_projection() throws Exception {
        // given
        List<String> result = queryFactory
                .select(guest.userName)
                .from(guest)
                .fetch();
        // when
        
        // then
        for (String s : result) {
            System.out.println("result : " + result);
        }
    }
    
    @Test
    public void 튜플프로젝션_Tuple() throws Exception {
        // given
        List<Tuple> result = queryFactory
                .select(guest.userName, guest.age)
                .from(guest)
                .fetch();
        // when

        // then
        System.out.println("result = " + result);
    }

    @Test
    public void JPQL_DTO_조회() throws Exception {
        // given
        List<GuestDto> result = em.createQuery("select new cashewnut.economy.user.guest.dto.GuestDto(g.userName, g.age) from Guest g", GuestDto.class)
                .getResultList();

        // when
        for (GuestDto guestDto : result) {
            System.out.println("guestDto = " + guestDto);
        }
        // then
    }

    @Test
    public void findDtoBySetter() throws Exception {
        // given
        List<Tuple> result = queryFactory
                .select(Projections.bean(GuestDto.class), guest.userName, guest.age)
                .from(guest)
                .fetch();
        // when
        for (Tuple tuple : result) {
            System.out.println("tuple = " + tuple);
        }
        // then
    }

    @Test
    public void findDtoByField() throws Exception {
        // given
        List<Tuple> result = queryFactory
                .select(Projections.fields(GuestDto.class), guest.userName, guest.age)
                .from(guest)
                .fetch();
        // when
        for (Tuple tuple : result) {
            System.out.println("tuple = " + tuple);
        }
        // then
    }

    @Test
    public void findDtoByConstructor() throws Exception {
        // given
        List<Tuple> result = queryFactory
                .select(Projections.constructor(GuestDto.class), guest.userName, guest.age)
                .from(guest)
                .fetch();
        // when
        for (Tuple tuple : result) {
            System.out.println("tuple = " + tuple);
        }
        // then
    }

    @Test
    public void findUserDtoByGuest_필드명다름() throws Exception {

        QGuest guestSub = new QGuest("guestSub");
        // given
        List<Tuple> result = queryFactory
                .select(
                        Projections.fields(UserDto.class),
                        guest.userName.as("name"),

                        ExpressionUtils.as(JPAExpressions
                                .select(guestSub.age.max())
                                .from(guestSub), "age")
                )
                .from(guest)
                .fetch();
        // when
        for (Tuple tuple : result) {
            System.out.println("tuple = " + tuple);
        }
        // then
    }

    /**
     * DTO 주요 사용방식
     * @throws Exception
     */
    @Test
    public void QGuestDto() throws Exception {
        // given
        List<GuestDto> result = queryFactory
                .select(
                        new QGuestDto(guest.userName, guest.age)
                )
                .from(guest)
                .fetch();
        // when
        for (GuestDto guestDto : result) {
            System.out.println("guestDto = " + guestDto);
        }
        // then
    }

    @Test
    public void 동적쿼리_BooleanBuilder() throws Exception {
        // given
        String usernameParam = "guest1";
        Integer ageparam = 10;
        // when
        List<Guest> result = searchGuest1(usernameParam, ageparam);
        assertThat(result.size()).isEqualTo(1);
        // then
    }

    private List<Guest> searchGuest1(String usernameCond, Integer ageCond) {

        BooleanBuilder builder = new BooleanBuilder();
        if(usernameCond != null) {
            builder.and(guest.userName.eq(usernameCond));
        }

        if(ageCond != null) {
            builder.and(guest.age.eq(ageCond));
        }

        return queryFactory
                .select(guest)
                .from(guest)
                .where(builder)
                .fetch();
    }

    @Test
    public void 동적쿼리_whereParam() throws Exception {
        // given
        String usernameParam = "guest1";
        Integer ageparam = 10;
        // when
        List<Guest> result = searchGuest2(usernameParam, ageparam);
        assertThat(result.size()).isEqualTo(1);
        // then
    }

    /**
     * 동적쿼리 주요 사용방식
     * @param usernameCond
     * @param ageCond
     * @return
     */
    private List<Guest> searchGuest2(String usernameCond, Integer ageCond) {

        return queryFactory
                .selectFrom(guest)
                .where(usernameEq(usernameCond), ageEq(ageCond))
                .fetch();
    }

    private BooleanExpression ageEq(Integer ageCond) {
        //삼항연산자
        return ageCond == null ? null : guest.age.eq(ageCond);
    }

    private BooleanExpression usernameEq(String usernameCond) {
        if(usernameCond == null) {
            return null;
        }
        return guest.userName.eq(usernameCond);
    }

    private BooleanExpression allEq(String usernameCond, int ageCond) {
        return usernameEq(usernameCond).and(ageEq(ageCond));
    }
    
    @Test
    public void bulkUpdate() throws Exception {
        // given
        long count = queryFactory
                .update(guest)
                .set(guest.userName, "비회원")
                .where(guest.age.lt(28))
                .execute();
        // when
        em.flush();
        em.clear();
        // then
        List<Guest> result = queryFactory
                .selectFrom(guest)
                .fetch();

        for (Guest guest : result) {
            System.out.println("guest = " + guest);
        }
    }

    @Test
    public void bulk_더하기() throws Exception {
        // given
        long count = queryFactory
                .update(guest)
                .set(guest.age, guest.age.add(30))
                .execute();
        // when
        em.flush();
        em.clear();
        // then
    }

    public void bulk_곱하기() throws Exception {
        // given
        long count = queryFactory
                .update(guest)
                .set(guest.age, guest.age.multiply(100))
                .execute();
        // when
        em.flush();
        em.clear();
        // then
    }
    @Test
    public void bulk_삭제() throws Exception {
        // given
        long count = queryFactory
                .delete(guest)
                .where(guest.age.gt(18))
                .execute();
        // when
        em.flush();
        em.clear();
        // then
    }

    @Test
    public void SQL_FUNCTION1() throws Exception {
        // given
        List<String> result = queryFactory
                .select(Expressions.stringTemplate(
                        "function('replace', {0},{1},{2})",
                        guest.userName, "guest", "G")
                )
                .from(guest)
                .fetch();

        for (String s : result) {
            System.out.println("s = " + s);
        }
        // when

        // then
    }

    @Test
    public void SQL_FUNCTION2() throws Exception {
        List<String> result = queryFactory
                .select(guest.userName)
                .from(guest)
//                .where(guest.userName.eq(
//                                Expressions.stringTemplate("function('lower', {0})", guest.userName)
//                        )
//                )
                .where(guest.userName.eq(guest.userName.lower()))
                .fetch();

        for (String s : result) {
            System.out.println("s = " + s);
        }
    }
}
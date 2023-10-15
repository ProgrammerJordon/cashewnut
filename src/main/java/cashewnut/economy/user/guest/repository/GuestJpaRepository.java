package cashewnut.economy.user.guest.repository;

import cashewnut.economy.user.guest.dto.GuestSearchCondition;
import cashewnut.economy.user.guest.dto.GuestTeamDto;
import cashewnut.economy.user.guest.dto.QGuestTeamDto;
import cashewnut.economy.user.guest.entity.Guest;
import cashewnut.economy.user.guest.entity.QGuest;
import cashewnut.economy.user.membership.entity.QTeam;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

import static cashewnut.economy.user.guest.entity.QGuest.guest;
import static cashewnut.economy.user.membership.entity.QTeam.team;
import static org.springframework.util.StringUtils.*;

@Repository
@RequiredArgsConstructor
public class GuestJpaRepository {

    private final EntityManager em;

    private final JPAQueryFactory queryFactory;

    public void save(Guest guest) {
        em.persist(guest);
    }

    public Optional<Guest> findById(Long id) {
        Guest findGuest = em.find(Guest.class, id);
        return Optional.ofNullable(findGuest);
    }

    public List<Guest> findAll() {
        return em.createQuery("select g from Guest g", Guest.class)
                .getResultList();
    }

    public List<Guest> findAll_QueryDSL() {
        return queryFactory
                .selectFrom(guest)
                .fetch();
    }

    public List<Guest> findByUserName(String userName) {
        return em.createQuery("select g from Guest g where g.userName = :userName", Guest.class)
                .setParameter("userName", userName)
                .getResultList();
    }

    public List<Guest> findByUserName_QueryDSL(String userName) {
        return queryFactory
                .selectFrom(guest)
                .where(guest.userName.eq(userName))
                .fetch();
    }

    public List<GuestTeamDto> searchByBuilder(GuestSearchCondition condition) {

        BooleanBuilder builder = new BooleanBuilder();

        if(hasText(condition.getUserName())) {
            builder.and(guest.userName.eq(condition.getUserName()));
        }

        if(StringUtils.hasText(condition.getTeamName())) {
            builder.and(team.name.eq(condition.getTeamName()));
        }

        if(condition.getAgeGoe() != null) {
            builder.and(guest.age.goe(condition.getAgeGoe()));
        }

        if(condition.getAgeLoe() != null) {
            builder.and(guest.age.loe(condition.getAgeLoe()));
        }
        return queryFactory
                .select(new QGuestTeamDto(
                        guest.id.as("guestId"),
                        guest.userName,
                        guest.age,
                        team.id.as("teamId"),
                        team.name.as("teamName")
                ))
                .from(guest)
                .leftJoin(guest.team, team)
                .where(builder)
                .fetch();

    }

    public List<GuestTeamDto> searchByBuilder2(GuestSearchCondition condition) {
        return queryFactory
                .select(new QGuestTeamDto(
                        guest.id.as("guestId"),
                        guest.userName,
                        guest.age,
                        team.id.as("teamId"),
                        team.name.as("teamName")
                ))
                .from(guest)
                .leftJoin(guest.team, team)
                .where(
                        userNameEq(condition.getUserName()),
                        teamNameEq(condition.getTeamName()),
                        ageGoe(condition.getAgeGoe()),
                        ageLoe(condition.getAgeLoe())

                )
                .fetch();
    }

    private BooleanExpression userNameEq(String userName) {
        return hasText(userName) ? guest.userName.eq(userName) : null;
    }

    private BooleanExpression teamNameEq(String teamName) {
        return hasText(teamName) ? team.name.eq(teamName) : null;
    }

    private BooleanExpression ageGoe(Integer ageGoe) {
        return ageGoe != null ? guest.age.goe(ageGoe) : null;
    }

    private BooleanExpression ageLoe(Integer ageLoe) {
        return ageLoe != null ? guest.age.loe(ageLoe) : null;
    }
}

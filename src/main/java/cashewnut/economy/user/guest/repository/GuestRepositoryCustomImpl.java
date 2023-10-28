package cashewnut.economy.user.guest.repository;

import cashewnut.economy.user.guest.dto.GuestSearchCondition;
import cashewnut.economy.user.guest.dto.GuestTeamDto;
import cashewnut.economy.user.guest.dto.QGuestTeamDto;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;

import static cashewnut.economy.user.guest.entity.QGuest.guest;
import static cashewnut.economy.user.membership.entity.QTeam.team;
import static org.springframework.util.StringUtils.hasText;

public class GuestRepositoryCustomImpl implements GuestRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public GuestRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public List<GuestTeamDto> seach(GuestSearchCondition condition) {
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

    @Override
    public Page<GuestTeamDto> seachPageSimple(GuestSearchCondition condition, Pageable pageable) {
        QueryResults<GuestTeamDto> results = queryFactory
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
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        List<GuestTeamDto> content = results.getResults();
        long total = results.getTotal();
        return new PageImpl<GuestTeamDto>(content, pageable, total);

    }

    @Override
    public Page<GuestTeamDto> seachPageComplex(GuestSearchCondition condition, Pageable pageable) {
        return null;
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

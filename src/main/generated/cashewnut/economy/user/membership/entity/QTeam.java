package cashewnut.economy.user.membership.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTeam is a Querydsl query type for Team
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTeam extends EntityPathBase<Team> {

    private static final long serialVersionUID = 71474365L;

    public static final QTeam team = new QTeam("team");

    public final ListPath<cashewnut.economy.user.guest.entity.Guest, cashewnut.economy.user.guest.entity.QGuest> Guests = this.<cashewnut.economy.user.guest.entity.Guest, cashewnut.economy.user.guest.entity.QGuest>createList("Guests", cashewnut.economy.user.guest.entity.Guest.class, cashewnut.economy.user.guest.entity.QGuest.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<cashewnut.economy.user.member.domain.Member, cashewnut.economy.user.member.domain.QMember> Members = this.<cashewnut.economy.user.member.domain.Member, cashewnut.economy.user.member.domain.QMember>createList("Members", cashewnut.economy.user.member.domain.Member.class, cashewnut.economy.user.member.domain.QMember.class, PathInits.DIRECT2);

    public final ListPath<Membership, QMembership> MemberShips = this.<Membership, QMembership>createList("MemberShips", Membership.class, QMembership.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public QTeam(String variable) {
        super(Team.class, forVariable(variable));
    }

    public QTeam(Path<? extends Team> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTeam(PathMetadata metadata) {
        super(Team.class, metadata);
    }

}


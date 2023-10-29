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

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTeam team = new QTeam("team");

    public final cashewnut.economy.common.QTrack _super = new cashewnut.economy.common.QTrack(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final ListPath<cashewnut.economy.user.guest.entity.Guest, cashewnut.economy.user.guest.entity.QGuest> Guests = this.<cashewnut.economy.user.guest.entity.Guest, cashewnut.economy.user.guest.entity.QGuest>createList("Guests", cashewnut.economy.user.guest.entity.Guest.class, cashewnut.economy.user.guest.entity.QGuest.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final cashewnut.economy.user.master.entity.QMaster master;

    public final ListPath<cashewnut.economy.user.member.domain.Member, cashewnut.economy.user.member.domain.QMember> Members = this.<cashewnut.economy.user.member.domain.Member, cashewnut.economy.user.member.domain.QMember>createList("Members", cashewnut.economy.user.member.domain.Member.class, cashewnut.economy.user.member.domain.QMember.class, PathInits.DIRECT2);

    public final ListPath<Membership, QMembership> MemberShips = this.<Membership, QMembership>createList("MemberShips", Membership.class, QMembership.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public QTeam(String variable) {
        this(Team.class, forVariable(variable), INITS);
    }

    public QTeam(Path<? extends Team> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTeam(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTeam(PathMetadata metadata, PathInits inits) {
        this(Team.class, metadata, inits);
    }

    public QTeam(Class<? extends Team> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.master = inits.isInitialized("master") ? new cashewnut.economy.user.master.entity.QMaster(forProperty("master")) : null;
    }

}


package cashewnut.membership.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import cashewnut.economy.user.membership.entity.Membership;
import cashewnut.economy.user.membership.entity.Team;
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

    private static final long serialVersionUID = -1589734922L;

    public static final QTeam team = new QTeam("team");

    public final NumberPath<Long> id = createNumber("id", Long.class);

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


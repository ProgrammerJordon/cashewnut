package cashewnut.user.guest.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGuest is a Querydsl query type for Guest
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGuest extends EntityPathBase<Guest> {

    private static final long serialVersionUID = 760890817L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGuest guest = new QGuest("guest");

    public final cashewnut.common.util.QTrack _super = new cashewnut.common.util.QTrack(this);

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final cashewnut.user.membership.domain.QTeam team;

    public final StringPath userName = createString("userName");

    public QGuest(String variable) {
        this(Guest.class, forVariable(variable), INITS);
    }

    public QGuest(Path<? extends Guest> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGuest(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGuest(PathMetadata metadata, PathInits inits) {
        this(Guest.class, metadata, inits);
    }

    public QGuest(Class<? extends Guest> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.team = inits.isInitialized("team") ? new cashewnut.user.membership.domain.QTeam(forProperty("team"), inits.get("team")) : null;
    }

}


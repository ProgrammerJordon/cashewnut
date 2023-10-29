package cashewnut.economy.common;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTrack is a Querydsl query type for Track
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QTrack extends EntityPathBase<Track> {

    private static final long serialVersionUID = 1001208062L;

    public static final QTrack track = new QTrack("track");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.LocalDateTime.class);

    public QTrack(String variable) {
        super(Track.class, forVariable(variable));
    }

    public QTrack(Path<? extends Track> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTrack(PathMetadata metadata) {
        super(Track.class, metadata);
    }

}


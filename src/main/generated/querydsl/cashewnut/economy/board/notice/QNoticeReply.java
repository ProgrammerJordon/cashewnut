package cashewnut.economy.board.notice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNoticeReply is a Querydsl query type for NoticeReply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNoticeReply extends EntityPathBase<NoticeReply> {

    private static final long serialVersionUID = 1123601754L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNoticeReply noticeReply = new QNoticeReply("noticeReply");

    public final cashewnut.economy.common.QTrack _super = new cashewnut.economy.common.QTrack(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final QNotice notice;

    public final StringPath replyContents = createString("replyContents");

    public final NumberPath<Integer> viewCount = createNumber("viewCount", Integer.class);

    public QNoticeReply(String variable) {
        this(NoticeReply.class, forVariable(variable), INITS);
    }

    public QNoticeReply(Path<? extends NoticeReply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNoticeReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNoticeReply(PathMetadata metadata, PathInits inits) {
        this(NoticeReply.class, metadata, inits);
    }

    public QNoticeReply(Class<? extends NoticeReply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.notice = inits.isInitialized("notice") ? new QNotice(forProperty("notice"), inits.get("notice")) : null;
    }

}


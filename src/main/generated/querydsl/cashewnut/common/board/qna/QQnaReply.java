package cashewnut.common.board.qna;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQnaReply is a Querydsl query type for QnaReply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQnaReply extends EntityPathBase<QnaReply> {

    private static final long serialVersionUID = 1323232021L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQnaReply qnaReply = new QQnaReply("qnaReply");

    public final cashewnut.common.util.QTrack _super = new cashewnut.common.util.QTrack(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final QQna qna;

    public final StringPath replyContents = createString("replyContents");

    public final NumberPath<Integer> viewCount = createNumber("viewCount", Integer.class);

    public QQnaReply(String variable) {
        this(QnaReply.class, forVariable(variable), INITS);
    }

    public QQnaReply(Path<? extends QnaReply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQnaReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQnaReply(PathMetadata metadata, PathInits inits) {
        this(QnaReply.class, metadata, inits);
    }

    public QQnaReply(Class<? extends QnaReply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.qna = inits.isInitialized("qna") ? new QQna(forProperty("qna"), inits.get("qna")) : null;
    }

}


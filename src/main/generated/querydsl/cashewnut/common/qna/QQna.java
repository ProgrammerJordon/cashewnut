package cashewnut.common.qna;

import static com.querydsl.core.types.PathMetadataFactory.*;

import cashewnut.common.board.qna.Qna;
import cashewnut.common.board.qna.QnaReply;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQna is a Querydsl query type for Qna
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQna extends EntityPathBase<Qna> {

    private static final long serialVersionUID = -1601138147L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQna qna = new QQna("qna");

    public final cashewnut.common.util.QTrack _super = new cashewnut.common.util.QTrack(this);

    public final StringPath contents = createString("contents");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final cashewnut.user.master.domain.QMaster master;

    public final ListPath<QnaReply, QQnaReply> qnaReplyList = this.<QnaReply, QQnaReply>createList("qnaReplyList", QnaReply.class, QQnaReply.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public final NumberPath<Integer> viewCount = createNumber("viewCount", Integer.class);

    public QQna(String variable) {
        this(Qna.class, forVariable(variable), INITS);
    }

    public QQna(Path<? extends Qna> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQna(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQna(PathMetadata metadata, PathInits inits) {
        this(Qna.class, metadata, inits);
    }

    public QQna(Class<? extends Qna> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.master = inits.isInitialized("master") ? new cashewnut.user.master.domain.QMaster(forProperty("master")) : null;
    }

}


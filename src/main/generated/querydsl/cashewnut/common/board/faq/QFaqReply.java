package cashewnut.common.board.faq;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFaqReply is a Querydsl query type for FaqReply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFaqReply extends EntityPathBase<FaqReply> {

    private static final long serialVersionUID = -1540986831L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFaqReply faqReply = new QFaqReply("faqReply");

    public final cashewnut.common.util.QTrack _super = new cashewnut.common.util.QTrack(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final QFaq faq;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath replyContents = createString("replyContents");

    public final NumberPath<Integer> viewCount = createNumber("viewCount", Integer.class);

    public QFaqReply(String variable) {
        this(FaqReply.class, forVariable(variable), INITS);
    }

    public QFaqReply(Path<? extends FaqReply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFaqReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFaqReply(PathMetadata metadata, PathInits inits) {
        this(FaqReply.class, metadata, inits);
    }

    public QFaqReply(Class<? extends FaqReply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.faq = inits.isInitialized("faq") ? new QFaq(forProperty("faq"), inits.get("faq")) : null;
    }

}


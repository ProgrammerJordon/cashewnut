package cashewnut.common.faq;

import static com.querydsl.core.types.PathMetadataFactory.*;

import cashewnut.common.board.faq.Faq;
import cashewnut.common.board.faq.FaqReply;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFaq is a Querydsl query type for Faq
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFaq extends EntityPathBase<Faq> {

    private static final long serialVersionUID = 1163809665L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFaq faq = new QFaq("faq");

    public final cashewnut.common.util.QTrack _super = new cashewnut.common.util.QTrack(this);

    public final StringPath contents = createString("contents");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final ListPath<FaqReply, QFaqReply> faqReplyList = this.<FaqReply, QFaqReply>createList("faqReplyList", FaqReply.class, QFaqReply.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final cashewnut.user.master.domain.QMaster master;

    public final StringPath title = createString("title");

    public final NumberPath<Integer> viewCount = createNumber("viewCount", Integer.class);

    public QFaq(String variable) {
        this(Faq.class, forVariable(variable), INITS);
    }

    public QFaq(Path<? extends Faq> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFaq(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFaq(PathMetadata metadata, PathInits inits) {
        this(Faq.class, metadata, inits);
    }

    public QFaq(Class<? extends Faq> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.master = inits.isInitialized("master") ? new cashewnut.user.master.domain.QMaster(forProperty("master")) : null;
    }

}


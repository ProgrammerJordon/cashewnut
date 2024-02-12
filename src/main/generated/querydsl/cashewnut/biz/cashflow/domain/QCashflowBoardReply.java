package cashewnut.biz.cashflow.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCashflowBoardReply is a Querydsl query type for CashflowBoardReply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCashflowBoardReply extends EntityPathBase<CashflowBoardReply> {

    private static final long serialVersionUID = -928481469L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCashflowBoardReply cashflowBoardReply = new QCashflowBoardReply("cashflowBoardReply");

    public final cashewnut.common.util.QTrack _super = new cashewnut.common.util.QTrack(this);

    public final QCashflowBoard cashflowBoard;

    public final StringPath content = createString("content");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public QCashflowBoardReply(String variable) {
        this(CashflowBoardReply.class, forVariable(variable), INITS);
    }

    public QCashflowBoardReply(Path<? extends CashflowBoardReply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCashflowBoardReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCashflowBoardReply(PathMetadata metadata, PathInits inits) {
        this(CashflowBoardReply.class, metadata, inits);
    }

    public QCashflowBoardReply(Class<? extends CashflowBoardReply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cashflowBoard = inits.isInitialized("cashflowBoard") ? new QCashflowBoard(forProperty("cashflowBoard")) : null;
    }

}


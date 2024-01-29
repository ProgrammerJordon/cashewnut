package cashewnut.biz.cashflow.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCashflowBoard is a Querydsl query type for CashflowBoard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCashflowBoard extends EntityPathBase<CashflowBoard> {

    private static final long serialVersionUID = 1096743911L;

    public static final QCashflowBoard cashflowBoard = new QCashflowBoard("cashflowBoard");

    public final cashewnut.common.util.QTrack _super = new cashewnut.common.util.QTrack(this);

    public final ListPath<CashflowBoardReply, QCashflowBoardReply> cashflowBoardReplyList = this.<CashflowBoardReply, QCashflowBoardReply>createList("cashflowBoardReplyList", CashflowBoardReply.class, QCashflowBoardReply.class, PathInits.DIRECT2);

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

    public final StringPath title = createString("title");

    public QCashflowBoard(String variable) {
        super(CashflowBoard.class, forVariable(variable));
    }

    public QCashflowBoard(Path<? extends CashflowBoard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCashflowBoard(PathMetadata metadata) {
        super(CashflowBoard.class, metadata);
    }

}


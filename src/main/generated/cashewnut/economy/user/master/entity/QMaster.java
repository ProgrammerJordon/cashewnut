package cashewnut.economy.user.master.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMaster is a Querydsl query type for Master
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMaster extends EntityPathBase<Master> {

    private static final long serialVersionUID = -1201624882L;

    public static final QMaster master = new QMaster("master");

    public final cashewnut.economy.common.QTrack _super = new cashewnut.economy.common.QTrack(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final ListPath<cashewnut.economy.board.faq.Faq, cashewnut.economy.board.faq.QFaq> faqList = this.<cashewnut.economy.board.faq.Faq, cashewnut.economy.board.faq.QFaq>createList("faqList", cashewnut.economy.board.faq.Faq.class, cashewnut.economy.board.faq.QFaq.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final ListPath<cashewnut.economy.board.notice.Notice, cashewnut.economy.board.notice.QNotice> noticeList = this.<cashewnut.economy.board.notice.Notice, cashewnut.economy.board.notice.QNotice>createList("noticeList", cashewnut.economy.board.notice.Notice.class, cashewnut.economy.board.notice.QNotice.class, PathInits.DIRECT2);

    public final ListPath<cashewnut.economy.board.qna.Qna, cashewnut.economy.board.qna.QQna> qnaList = this.<cashewnut.economy.board.qna.Qna, cashewnut.economy.board.qna.QQna>createList("qnaList", cashewnut.economy.board.qna.Qna.class, cashewnut.economy.board.qna.QQna.class, PathInits.DIRECT2);

    public final ListPath<cashewnut.economy.user.membership.entity.Team, cashewnut.economy.user.membership.entity.QTeam> teamList = this.<cashewnut.economy.user.membership.entity.Team, cashewnut.economy.user.membership.entity.QTeam>createList("teamList", cashewnut.economy.user.membership.entity.Team.class, cashewnut.economy.user.membership.entity.QTeam.class, PathInits.DIRECT2);

    public QMaster(String variable) {
        super(Master.class, forVariable(variable));
    }

    public QMaster(Path<? extends Master> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMaster(PathMetadata metadata) {
        super(Master.class, metadata);
    }

}


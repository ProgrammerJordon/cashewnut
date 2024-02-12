package cashewnut.user.master.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMaster is a Querydsl query type for Master
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMaster extends EntityPathBase<Master> {

    private static final long serialVersionUID = 2065768061L;

    public static final QMaster master = new QMaster("master");

    public final cashewnut.common.util.QTrack _super = new cashewnut.common.util.QTrack(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final ListPath<cashewnut.common.board.faq.Faq, cashewnut.common.board.faq.QFaq> faqList = this.<cashewnut.common.board.faq.Faq, cashewnut.common.board.faq.QFaq>createList("faqList", cashewnut.common.board.faq.Faq.class, cashewnut.common.board.faq.QFaq.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final ListPath<cashewnut.common.board.notice.Notice, cashewnut.common.board.notice.QNotice> noticeList = this.<cashewnut.common.board.notice.Notice, cashewnut.common.board.notice.QNotice>createList("noticeList", cashewnut.common.board.notice.Notice.class, cashewnut.common.board.notice.QNotice.class, PathInits.DIRECT2);

    public final ListPath<cashewnut.common.board.qna.Qna, cashewnut.common.board.qna.QQna> qnaList = this.<cashewnut.common.board.qna.Qna, cashewnut.common.board.qna.QQna>createList("qnaList", cashewnut.common.board.qna.Qna.class, cashewnut.common.board.qna.QQna.class, PathInits.DIRECT2);

    public final ListPath<cashewnut.user.membership.domain.Team, cashewnut.user.membership.domain.QTeam> teamList = this.<cashewnut.user.membership.domain.Team, cashewnut.user.membership.domain.QTeam>createList("teamList", cashewnut.user.membership.domain.Team.class, cashewnut.user.membership.domain.QTeam.class, PathInits.DIRECT2);

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


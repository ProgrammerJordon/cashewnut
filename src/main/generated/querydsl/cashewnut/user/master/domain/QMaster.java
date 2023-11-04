package cashewnut.user.master.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import cashewnut.common.board.faq.Faq;
import cashewnut.common.board.notice.Notice;
import cashewnut.common.board.qna.Qna;
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

    private static final long serialVersionUID = 2065768061L;

    public static final QMaster master = new QMaster("master");

    public final cashewnut.common.util.QTrack _super = new cashewnut.common.util.QTrack(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final ListPath<Faq, cashewnut.common.faq.QFaq> faqList = this.<Faq, cashewnut.common.faq.QFaq>createList("faqList", Faq.class, cashewnut.common.faq.QFaq.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final ListPath<Notice, cashewnut.common.notice.QNotice> noticeList = this.<Notice, cashewnut.common.notice.QNotice>createList("noticeList", Notice.class, cashewnut.common.notice.QNotice.class, PathInits.DIRECT2);

    public final ListPath<Qna, cashewnut.common.qna.QQna> qnaList = this.<Qna, cashewnut.common.qna.QQna>createList("qnaList", Qna.class, cashewnut.common.qna.QQna.class, PathInits.DIRECT2);

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


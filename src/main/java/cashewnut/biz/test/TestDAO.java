package cashewnut.biz.test;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {

    @Autowired //자동 의존성 주입
    private SqlSession sqlSession;

    int insertTest(TestVO testVO) {
        return this.sqlSession.insert("insertTestVO", testVO);
    }
}

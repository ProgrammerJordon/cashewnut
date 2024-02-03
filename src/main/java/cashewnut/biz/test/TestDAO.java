package cashewnut.biz.test;

import lombok.AllArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class TestDAO {

    SqlSessionTemplate sqlSessionTemplate;

    public void InsertTest(TestVO testVO) throws Exception {
        sqlSessionTemplate.insert("id", testVO);
    }

    public void UpdateTest(TestVO testVO) throws Exception {
        sqlSessionTemplate.update("id", testVO);
    }

}

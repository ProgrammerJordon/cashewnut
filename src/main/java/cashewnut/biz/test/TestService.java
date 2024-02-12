package cashewnut.biz.test;

import java.util.List;

public interface TestService {

    void insertTest(TestVO testVO) throws Exception;

    void updateTest(TestVO testVO) throws Exception;

    List<TestVO> selectTest() throws Exception;
}

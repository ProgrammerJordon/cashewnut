package cashewnut.biz.test;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TestServiceImpl implements TestService{

    TestDAO testdao;

    @Override
    public void InsertTest(TestVO testVO) throws Exception {
        testdao.InsertTest(testVO);
    }

    @Override
    public void UpdateTest(TestVO testVO) throws Exception {
        testdao.UpdateTest(testVO);
    }

}

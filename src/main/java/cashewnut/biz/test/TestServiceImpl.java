package cashewnut.biz.test;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestServiceImpl implements TestService {

    private  TestDAO testDAO;

    @Override
    public void insertTest(TestVO testVO) throws Exception {
        testDAO.insertTest(testVO);
    }

    @Override
    public void updateTest(TestVO testVO) throws Exception {
        testDAO.updateTest(testVO);
    }

    @Override
    public List<TestVO> selectTest() throws Exception {
        List<TestVO> list = testDAO.selectTest();
        return list;
    }

}

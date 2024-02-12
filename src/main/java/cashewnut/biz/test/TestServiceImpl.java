package cashewnut.biz.test;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TestServiceImpl implements TestService {

    private  TestDAO testDAO;

    @Override
    public void insertTest(TestVO testVO) throws Exception {
        testDAO.insertTest(testVO);
    }

}

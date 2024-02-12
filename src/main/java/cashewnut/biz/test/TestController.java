package cashewnut.biz.test;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class TestController {
    private TestService testService;
    @RequestMapping("/test")
    public String testView() {
        return "/test/testPage";
    }

//    @RequestMapping("selectTest")
//    public String selectTest() throws Exception {
//        List<TestVO> testvo = new TestVO();
//        List<testVO> list = testService.selectTest();
//
//        System.out.println("result list : " + list);
//
//        return "/test/select_page";
//    }

    @RequestMapping("/insertTest")
    public String insertTest(TestVO testVO) throws Exception {
        testService.insertTest(testVO);

        return "/test/success_page";
    }

    @RequestMapping("/updateTest")
    public String updateTest(TestVO testVO) throws Exception {
        testService.updateTest(testVO);

        return "/test/success_page";
    }

}
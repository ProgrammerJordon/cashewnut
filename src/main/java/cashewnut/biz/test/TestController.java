package cashewnut.biz.test;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class TestController {
    private TestService testService;
    @RequestMapping("/test")
    public String testView() {
        return "/test/testPage";
    }
    @RequestMapping("/insertTest")
    public void insertTest(TestVO testVO) throws Exception {
        testService.insertTest(testVO);
    }
}
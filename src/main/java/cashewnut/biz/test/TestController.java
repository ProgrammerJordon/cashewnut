package cashewnut.biz.test;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class TestController {

    private TestService testService;

    @RequestMapping("/test_call")
    public String test_call() {

        return "/test/testPage";
    }

    @RequestMapping("/InsertTest")
    public void InsertTest(TestVO testVO) throws Exception {
        testService.InsertTest(testVO);
    }

    @RequestMapping("/UpdateTest")
    public void UpdateTest(TestVO testVO) throws Exception {
        testService.UpdateTest(testVO);
    }

}

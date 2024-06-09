package cashewnut.biz.test;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class TestController {
    private TestService testService;

    @RequestMapping("/test")
    public String testView() {
        return "/test/testPage";
    }


    @RequestMapping("selectTest")
    public String selectTest(Model model) throws Exception {

        List<TestVO> get_list = testService.selectTest();
        model.addAttribute("list",get_list);

        System.out.println("result list : " + get_list);

        return "/test/select_page";
    }


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
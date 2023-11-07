package cashewnut.biz.main.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    @RequestMapping("/main")
    public String main() {
        return "main/VIEW001001M";
    }
}

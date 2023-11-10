package cashewnut.biz.home.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequiredArgsConstructor
public class HomeController {
    @RequestMapping("/home")
    public String home() {
        return "home/VIEW010001M";
    }
}

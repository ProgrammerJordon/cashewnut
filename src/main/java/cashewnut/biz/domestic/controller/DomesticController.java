package cashewnut.biz.domestic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class DomesticController {

    @RequestMapping("/domestic")
    public String domestic() {
        return "domestic/VIEW001001M";
    }
}

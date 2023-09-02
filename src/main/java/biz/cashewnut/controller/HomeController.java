package biz.cashewnut.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HomeController {

    @ResponseBody
    public String home(@RequestBody Model model) {
        return "index.js";
    }
}

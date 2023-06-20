package biz.cashewnut.main.web;

import biz.cashewnut.main.service.mainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {
    private mainService ms;

    public mainController(mainService ms) {
        this.ms = ms;
    }

    @GetMapping("/main/view")
    public String test() {
        return "Hello, world! and last test";
    }
}

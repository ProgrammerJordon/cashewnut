package biz.cashewnut;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class axiosController {

    @GetMapping("/api/hello")
    public String test() {
        return "Hello, world! and last test";
    }
}

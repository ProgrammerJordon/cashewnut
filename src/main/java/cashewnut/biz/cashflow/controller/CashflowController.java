package cashewnut.biz.cashflow.controller;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class CashflowController {

    @RequestMapping("/cashflow")
    public String cashflow() {
        return "cashflow/VIEW006001M";
    }
}

package biz.cashewnut.controller;

import biz.cashewnut.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MemeberController {

    private final MemberService memberService;
}

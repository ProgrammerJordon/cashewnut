package cashewnut.user.member.controller;

import cashewnut.user.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MemeberController {

    private final MemberService memberService;
}

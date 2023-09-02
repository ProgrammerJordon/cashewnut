package biz.cashewnut.member.api;

import biz.cashewnut.member.domain.Member;
import biz.cashewnut.member.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/v1/members")
    public createMemberResponse saveMemberV1(@RequestBody @Valid Member member) {
        Long id = memberService.join(member);
        return new createMemberResponse(id);
    }

    @Data
    static class createMemberResponse {
        private Long id;
        public createMemberResponse(Long id) {
            this.id = id;
        }
    }
}

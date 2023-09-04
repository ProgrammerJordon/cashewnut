package biz.cashewnut.member.api;

import biz.cashewnut.member.domain.Address;
import biz.cashewnut.member.domain.Member;
import biz.cashewnut.member.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Embedded;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @GetMapping("/api/v1/members")
    public List<Member> membersV1() {
        return memberService.findMembers();
    }

    @GetMapping("/api/v2/members")
    public Result membersV2() {
        List<Member> findMembers = memberService.findMembers();
        List<MemberDto> collect = findMembers.stream()
                .map(m -> new MemberDto(m.getName()))
                .collect(Collectors.toList());
        return new Result(collect);
    }
    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class MemberDto {
        private String name;
    }
    @PostMapping("/api/v1/members")
    public createMemberResponse saveMemberV1(@RequestBody @Valid Member member) {
        Long id = memberService.join(member);
        return new createMemberResponse(id);
    }

    @PostMapping("/api/v2/members")
    public createMemberResponse saveMemberV2(@RequestBody @Valid createMemberRequest request) {
        Member member = new Member();
        member.setName(request.getName());
        member.setAddress(request.getAddress());
        Long id = memberService.join(member);
        return new createMemberResponse(id);
    }

    @PutMapping("/api/v2/members/{id}")
    public updateMemberResponse updateMemberV2(@PathVariable("id") Long id,
                                               @RequestBody @Valid updateMemberRequest request) {
        memberService.update(id, request.getName());
        Member findMember = memberService.findOne(id);
        return new updateMemberResponse(findMember.getId(), findMember.getName());
    }

    @Data
    static  class updateMemberRequest {
        private String name;
    }

    @Data
    @AllArgsConstructor
    static  class updateMemberResponse {
        private Long id;
        private String name;
    }

    @Data
    static class createMemberRequest {
        private String name;
        @Embedded
        private Address address;
    }

    @Data
    static class createMemberResponse {
        private Long id;
        public createMemberResponse(Long id) {
            this.id = id;
        }
    }
}

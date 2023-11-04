package cashewnut.user.member.api;

import cashewnut.user.member.domain.Address;
import cashewnut.user.member.service.MemberService;
import cashewnut.user.member.domain.Member;
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

    // 조회
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


    // 저장
    @PostMapping("/api/v2/members")
    public createMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberDto createMemberDto) {
        Member member = new Member();
        member.setName(createMemberDto.getName());
        member.setAddress(createMemberDto.getAddress());
        Long id = memberService.join(member);
        return new createMemberResponse(id);
    }

    @Data
    static class CreateMemberDto {
        //저장 전 DTO
        private String name;
        @Embedded
        private Address address;
    }

    @Data
    static class createMemberResponse {
        // 저장 후 DTO
        private Long id;
        public createMemberResponse(Long id) {
            this.id = id;
        }
    }

    // 수정
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
}

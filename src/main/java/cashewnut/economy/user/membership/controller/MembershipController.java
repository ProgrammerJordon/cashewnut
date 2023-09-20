package cashewnut.economy.user.membership.controller;

import cashewnut.economy.user.membership.repository.MembershipRepository;
import cashewnut.economy.user.membership.dto.MembershipDto;
import cashewnut.economy.user.membership.entity.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MembershipController {
    private final MembershipRepository membershipRepository;

    @GetMapping("/memberships")
    public Page<MembershipDto> list(@PageableDefault(size = 5) Pageable pageable) {
        Page<Membership> page = membershipRepository.findAll(pageable);
        //Page<MembershipDto> pageWrapper = page.map(membership -> new MembershipDto(membership.getId(), membership.getUserName(), null));
        Page<MembershipDto> pageWrapper = page.map(MembershipDto::new);
        return pageWrapper;
    }
}

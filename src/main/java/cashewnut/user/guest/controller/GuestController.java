package cashewnut.user.guest.controller;

import cashewnut.user.guest.dto.GuestSearchCondition;
import cashewnut.user.guest.dto.GuestTeamDto;
import cashewnut.user.guest.repository.GuestJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GuestController {

    // 조회는 여기다 떄려박으면 됨
    private final GuestJpaRepository guestJpaRepository;
    @GetMapping("/v1/guests")
    @ResponseBody
    public List<GuestTeamDto> searchGuestV1(GuestSearchCondition condition) {
        return guestJpaRepository.searchByBuilder2(condition);
    }
}

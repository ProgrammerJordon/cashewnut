package cashewnut.economy.user.guest.controller;

import cashewnut.economy.user.guest.dto.GuestSearchCondition;
import cashewnut.economy.user.guest.dto.GuestTeamDto;
import cashewnut.economy.user.guest.repository.GuestJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GuestController {

    private final GuestJpaRepository guestJpaRepository;

    @GetMapping("/v1/guests")
    public List<GuestTeamDto> searchGuestV1(GuestSearchCondition condition) {
        return guestJpaRepository.searchByBuilder2(condition);
    }
}

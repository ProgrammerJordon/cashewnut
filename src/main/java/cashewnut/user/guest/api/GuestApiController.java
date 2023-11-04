package cashewnut.user.guest.api;

import cashewnut.user.guest.dto.GuestSearchCondition;
import cashewnut.user.guest.dto.GuestTeamDto;
import cashewnut.user.guest.repository.GuestJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GuestApiController {

    // 등록 수정 삭제는 여기다 때려박으며 됨
    private final GuestJpaRepository guestJpaRepository;
    @GetMapping("/v11/guests")
    public List<GuestTeamDto> searchGuestV1(GuestSearchCondition condition) {
        return guestJpaRepository.searchByBuilder2(condition);
    }
}

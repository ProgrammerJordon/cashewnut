package cashewnut.economy.user.guest.repository;

import cashewnut.economy.user.guest.dto.GuestSearchCondition;
import cashewnut.economy.user.guest.dto.GuestTeamDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GuestRepositoryCustom {

    List<GuestTeamDto> seach (GuestSearchCondition condition);
    Page<GuestTeamDto> seachPageSimple (GuestSearchCondition condition, Pageable pageable);
    Page<GuestTeamDto> seachPageComplex (GuestSearchCondition condition, Pageable pageable);
}

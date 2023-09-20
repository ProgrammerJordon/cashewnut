package cashewnut.economy.user.membership.repository;

import cashewnut.economy.user.membership.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}

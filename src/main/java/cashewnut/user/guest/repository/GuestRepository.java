package cashewnut.user.guest.repository;

import cashewnut.user.guest.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByUserName(String userName);
}

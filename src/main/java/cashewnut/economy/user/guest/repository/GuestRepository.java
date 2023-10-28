package cashewnut.economy.user.guest.repository;

import cashewnut.economy.user.guest.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByUserName(String userName);
}

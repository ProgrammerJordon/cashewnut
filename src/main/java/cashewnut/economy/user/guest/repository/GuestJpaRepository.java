package cashewnut.economy.user.guest.repository;

import cashewnut.economy.user.guest.entity.Guest;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GuestJpaRepository {

    private final EntityManager em;

    private final JPAQueryFactory queryFactory;

    public void save(Guest guest) {
        em.persist(guest);
    }

    public Optional<Guest> findById(Long id) {
        Guest findGuest = em.find(Guest.class, id);
        return Optional.ofNullable(findGuest);
    }

    public List<Guest> findAll() {
        return em.createQuery("select g from Guest g", Guest.class)
                .getResultList();
    }

    public List<Guest> findByUserName(String userName) {
        em.createQuery("select g from Guest g where g.userName = :userName", Guest.class)
                .setParameter("userName", userName)
                .getResultList();

    }

}

package cashewnut.economy.user.guest.repository;

import cashewnut.economy.user.guest.entity.Guest;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GuestJpaRepositoryTest {

    @Autowired
    private EntityManager em;
    @Autowired
    private GuestJpaRepository guestJpaRepository;
    private JPAQueryFactory queryFactory;
    @Test
    public void 기초테스트() throws Exception {
        // given
        Guest guest = new Guest("guest1", 10);
        guestJpaRepository.save(guest);
        // when
        Guest findGuest = guestJpaRepository.findById(guest.getId()).get();
        // then
        Assertions.assertThat(findGuest).isEqualTo(guest);
        z
        guestJpaRepository.findAll();
    }

}
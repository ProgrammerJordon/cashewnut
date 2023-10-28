package cashewnut.economy.user.guest.repository;

import cashewnut.economy.user.guest.entity.Guest;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GuestRepositoryTest {

    @Autowired
    private EntityManager em;
    @Autowired
    private GuestRepository guestRepository;
    private JPAQueryFactory queryFactory;


    @Test
    public void 기초테스트() throws Exception {
        // given
        Guest guest = new Guest("guest1", 10);
        guestRepository.save(guest);
        // when
        Guest findGuest = guestRepository.findById(guest.getId()).get();
        // then
        Assertions.assertThat(findGuest).isEqualTo(guest);

        List<Guest> result = guestRepository.findAll();
        Assertions.assertThat(result).containsExactly(guest);

        List<Guest> result2 = guestRepository.findByUserName("guest1");
        Assertions.assertThat(result2).containsExactly(guest);
    }
}
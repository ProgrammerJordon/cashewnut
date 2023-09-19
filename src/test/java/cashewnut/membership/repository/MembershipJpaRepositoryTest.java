package cashewnut.membership.repository;

import cashewnut.membership.dto.MembershipDto;
import cashewnut.membership.entity.Membership;
import cashewnut.membership.entity.Team;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MembershipJpaRepositoryTest {

    @PersistenceContext
    EntityManager em;
    @Autowired
    MembershipJpaRepository membershipJpaRepository;
    @Autowired
    MembershipRepository membershipRepository;
    @Autowired
    TeamRepository teamRepository;

    @Test
    public void 유저레파지토리() {
        Membership memberShip = new Membership("JPA-DATA", 10);
        Membership saveUser = membershipJpaRepository.save(memberShip);
        Membership findUser = membershipJpaRepository.find(saveUser.getId());

        assertThat(findUser.getId()).isEqualTo(memberShip.getId());
        assertThat(findUser.getUserName()).isEqualTo(memberShip.getUserName());
        assertThat(findUser).isEqualTo(memberShip);
    }

    @Test
    public void CRUD체크() throws Exception {
        // given
        Membership membershipA = new Membership("memberA", 10);
        Membership membershipB = new Membership("memberB", 20);

        // when
        membershipJpaRepository.save(membershipA);
        membershipJpaRepository.save(membershipB);

        //then
        Membership findMembershipA = membershipJpaRepository.findById(membershipA.getId()).get();
        Membership findMembershipB = membershipJpaRepository.findById(membershipB.getId()).get();

        assertThat(findMembershipA).isEqualTo(membershipA);
        assertThat(findMembershipB).isEqualTo(membershipB);

        List<Membership> all = membershipJpaRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

        Long count = membershipJpaRepository.count();
        assertThat(count).isEqualTo(2);

        membershipJpaRepository.delete(membershipA);
        membershipJpaRepository.delete(membershipB);

        Long deletedCount = membershipJpaRepository.count();
        assertThat(deletedCount).isEqualTo(0);
    }

    @Test
    public void 파라미터검색() throws Exception {
        // given
        Membership membershipA = new Membership("A", 30);
        Membership membershipB = new Membership("A", 40);

        // when
        membershipJpaRepository.save(membershipA);
        membershipJpaRepository.save(membershipB);

        // then
        List<Membership> result = membershipJpaRepository.findByUsernameAndAgeGreaterThan("A", 30);
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    public void namedQuery() throws Exception {
        // given
        Membership membershipA = new Membership("AAA");
        Membership membershipB = new Membership("BBB");
        // when
        membershipRepository.save(membershipA);
        membershipRepository.save(membershipB);
        // then
        List<Membership> result = membershipRepository.findByUserName("AAA");
        Membership findMembership = result.get(0);
        assertThat(findMembership).isEqualTo(membershipA);

    }

    @Test
    public void directNamedQuery() throws Exception {
        // given
        Membership membershipA = new Membership("AAA", 10);
        Membership membershipB = new Membership("BBB", 20);
        // when
        membershipRepository.save(membershipA);
        membershipRepository.save(membershipB);
        // then
        List<Membership> result = membershipRepository.findMembership("AAA", 10);
        Membership membership = result.get(0);
        assertThat(membership).isEqualTo(membershipA);
    }
    @Test
    public void MembershipDtoList() throws Exception {
        // given
        Team team = new Team("TeamA");
        teamRepository.save(team);
        Membership membership = new Membership("AAA", 10);
        membershipRepository.save(membership);
        // when
        List<MembershipDto> membershipDto = membershipRepository.findMembershipDto();
        // then
        for (MembershipDto dto : membershipDto) {
            System.out.println("MembershipDto : " + dto);
        }
    }

    @Test
    public void InQueryMembership() throws Exception {
        // given
        Membership membershipA = new Membership("AAA", 10);
        Membership membershipB = new Membership("BBB", 20);
        // when
        membershipRepository.save(membershipA);
        membershipRepository.save(membershipB);
        // then
        List<Membership> result = membershipRepository.findByNames(Arrays.asList("AAA", "BBB"));
        for (Membership membership : result) {
            System.out.println("MembershipInQuery = " + membership);
        }
    }

    @Test
    public void 페이징() throws Exception {
        // given
        membershipRepository.save(new Membership("member1", 10));
        membershipRepository.save(new Membership("member2", 10));
        membershipRepository.save(new Membership("member3", 10));
        membershipRepository.save(new Membership("member4", 10));
        membershipRepository.save(new Membership("member5", 10));
        membershipRepository.save(new Membership("member6", 10));
        membershipRepository.save(new Membership("member7", 10));
        membershipRepository.save(new Membership("member8", 10));
        membershipRepository.save(new Membership("member9", 10));
        membershipRepository.save(new Membership("member10", 10));
        membershipRepository.save(new Membership("member11", 10));

        int age = 10;
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "userName"));
        // when
        Page<Membership> page = membershipRepository.findByAge(age, pageRequest);
        // then
        List<Membership> content = page.getContent();
        Long totalElement = page.getTotalElements();
        for (Membership membership : content) {
            System.out.println("content : " + membership);
        }
        System.out.println("totalEelment ; " + totalElement);
    }

    @Test
    public void bulkUpdate() throws Exception {
        // given
        membershipRepository.save(new Membership("member1", 10));
        membershipRepository.save(new Membership("member2", 19));
        membershipRepository.save(new Membership("member3", 20));
        membershipRepository.save(new Membership("member4", 21));
        membershipRepository.save(new Membership("member5", 42));
        // when
        int resultCount = membershipRepository.bulkAgePlus(20);
        /**
         * 업데이트 후 반드시 영속성 컨텍스 flush(객체초기화) / clear(캐쉬초기화) 필수
         * em.flush();
         * em.clear();
         */
        // then
        assertThat(resultCount).isEqualTo(3);
    }
}
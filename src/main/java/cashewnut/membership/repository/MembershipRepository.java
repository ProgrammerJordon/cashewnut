package cashewnut.membership.repository;

import cashewnut.membership.dto.MembershipDto;
import cashewnut.membership.entity.Membership;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface MembershipRepository extends JpaRepository<Membership, Long> {

    List<Membership> findByUserNameAndAgeGreaterThan(String userName, int age);

    @Query(name = "Membership.findByUserName")
    List<Membership> findByUserName(@Param("userName") String userName);

    @Query("select m from Membership m where m.userName = :userName and m.age = :age")
    List<Membership> findMembership(@Param("userName") String useName, @Param("age") int age);

    @Query("select new cashewnut.membership.dto.MembershipDto(m.id, m.userName, t.name) from Membership m join m.team t")
    List<MembershipDto> findMembershipDto();

    @Query("select m from Membership m where m.userName in :names")
    List<Membership> findByNames(@Param("names") Collection<String> names);

    Page<Membership> findByAge(int age, Pageable pageable);

    @Modifying(clearAutomatically = true)
    @Query("update Membership m set m.age = m.age+1 where m.age >= :age")
    int bulkAgePlus (@Param("age") int age);

    @Query("select m from Membership m left join m.team")
    List<Membership> findMembershipFetchJoin();
}
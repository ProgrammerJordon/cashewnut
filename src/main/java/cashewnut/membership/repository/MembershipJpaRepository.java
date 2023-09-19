package cashewnut.membership.repository;

import cashewnut.membership.entity.Membership;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class MembershipJpaRepository {

    @PersistenceContext
    EntityManager em;

    public Membership save(Membership user) {
        em.persist(user);
        return user;
    }

    public void delete(Membership membership) {
        em.remove(membership);
    }

    public List<Membership> findAll() {
        return em.createQuery("select m from Membership m")
                .getResultList();
    }

    public Optional<Membership> findById(Long id) {
        Membership membership = em.find(Membership.class, id);
        return Optional.ofNullable(membership);
    }

    public Long count() {
        return em.createQuery("select count(m) from Membership m", Long.class)
                .getSingleResult();
    }
    public Membership find(Long id) {
        return em.find(Membership.class, id);
    }

    public List<Membership> findByUsernameAndAgeGreaterThan(String userName, int age) {
        return em.createQuery("select m from Membership m where m.userName = :userName and m.age > :age")
                .setParameter("userName", userName)
                .setParameter("age", age)
                .getResultList();
    }

    public Long totalCount(int age) {
        return em.createQuery("select count(m) from Membership m where m.age > :age", Long.class)
                .setParameter("age", age)
                .getSingleResult();
    }

    public int bulkAgePlus (int age) {
        return em.createQuery("update Membership m set m.age = m.age+1 where m.age >= :age")
                .setParameter("age", age)
                .executeUpdate();
    }
}

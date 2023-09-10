package biz.cashewnut.member.repository;

import biz.cashewnut.member.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

    public List<Order> findAllByString(OrderSearch orderSearch) {
        return em.createQuery("select o from Order o join o.member m", Order.class)
                .setMaxResults(1000)
                .getResultList();
    }

    public List<Order> findAllWithMemberDelivery() {

        return em.createQuery("select o from Order o join fetch o.member m join fetch o.delivery d", Order.class)
                .getResultList();
    }

    public List<OrderSimpleQureyDto> findOrderDtos() {
        return em.createQuery("select new biz.cashewnut.member.repository.OrderSimpleQureyDto(o.id, m.name, o.orderDate, o.status, d.address) from Order o join o.member m join o.delivery d", OrderSimpleQureyDto.class)
                .getResultList();
    }

    public List<Order> findAllWithItem() {
        return em.createQuery("select distinct o from Order o join fetch o.member m join fetch o.delivery d join fetch o.orderItems oi join fetch oi.item i", Order.class)
                .getResultList();
        // toOne 관계는 fetch join사용
    }
}

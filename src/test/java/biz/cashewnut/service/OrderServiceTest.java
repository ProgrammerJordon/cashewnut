package biz.cashewnut.service;

import biz.cashewnut.domain.Address;
import biz.cashewnut.domain.Member;
import biz.cashewnut.domain.Order;
import biz.cashewnut.domain.OrderStatus;
import biz.cashewnut.domain.item.Book;
import biz.cashewnut.domain.item.Item;
import biz.cashewnut.exception.NotEnoughStockException;
import biz.cashewnut.repository.OrderRepository;
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
public class OrderServiceTest {

    @Autowired
    EntityManager em;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void 상품주문() throws Exception {
        // given
        Member member = createMember("jordan", "부산", "북구", "65674");
        Book book = createBook("JPA", 10000, 10);

        int orderCount = 2;
        // when
        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);
        // then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals("상품주문수 상태는 ORDER", OrderStatus.ORDER, getOrder.getStatus());
        assertEquals("주문한 상품 종류 수가 정확해야 한다.", 1, getOrder.getOrderItems().size());
        assertEquals("주문가격의 가격 * 수량이다.", 10000 * orderCount, getOrder.getTotalPrice());
        assertEquals("주문 수량만큼 제고가 줄어야한다.", 8, book.getStockQuantity());

    }

    @Test(expected = NotEnoughStockException.class)
    public void 상품주문_재고수량초과() throws Exception {
        // given
        Member member = createMember("jordan", "부산", "북구", "65674");
        Item item = createBook("JPA", 10000, 10);

        int orderCount = 11;
        // when
        orderService.order(member.getId(), item.getId(), orderCount);
        // then
        fail("재고수량 부족 에러가 발생됨");
    }

    @Test
    public void 주문취소() throws Exception {
        // given
        Member member = createMember("jordan", "부산", "북구", "65674");
        Item item = createBook("JPA", 10000, 10);

        int orderCount = 2;
        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);

        // when
        orderService.cancleOrder(orderId);
        // then
        Order getOrder = orderRepository.findOne(orderId);
        assertEquals("주문 취소시 상태는 CANCLE이다", OrderStatus.CANCLE, getOrder.getStatus());
        assertEquals("주문이 취소된 상품은 재고가 원상복구 되어야한다.", 10, item.getStockQuantity());
    }

    private Book createBook(String name, int price, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);
        em.persist(book);
        return book;
    }

    private Member createMember(String name, String city, String street, String zipcode) {
        Member member = new Member();
        member.setName(name);
        member.setAddress(new Address(city, street, zipcode));
        em.persist(member);
        return member;
    }

}
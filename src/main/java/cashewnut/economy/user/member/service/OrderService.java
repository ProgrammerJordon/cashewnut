package cashewnut.economy.user.member.service;

import cashewnut.economy.user.member.domain.Delivery;
import cashewnut.economy.user.member.domain.Member;
import cashewnut.economy.user.member.domain.Order;
import cashewnut.economy.user.member.domain.OrderItem;
import cashewnut.economy.user.member.domain.item.Item;
import cashewnut.economy.user.member.repository.ItemRepository;
import cashewnut.economy.user.member.repository.MemberRepository;
import cashewnut.economy.user.member.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    //주문
    public Long order (Long memberId, Long itemId, int count) {
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        //배송정보 조회
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        //주문상품
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        //주문생성
        Order order = Order.createOrder(member, delivery, orderItem);

        //주문저장
        orderRepository.save(order);
        return order.getId();
    }
    //취소
    @Transactional
    public void cancleOrder(Long orderId) {
        Order order = orderRepository.findOne(orderId);
        order.cancle();
    }
    //검색
//    public List<Order> findOrders(OrderSerch orderSearch) {
//        return orderRepository.findAll(orderSearch);
//    }
}

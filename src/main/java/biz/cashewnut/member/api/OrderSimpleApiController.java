package biz.cashewnut.member.api;

import biz.cashewnut.member.domain.Order;
import biz.cashewnut.member.repository.OrderRepository;
import biz.cashewnut.member.repository.OrderSearch;
import biz.cashewnut.member.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {

    private final OrderRepository orderRepository;

    @GetMapping("/api/v1/simple-orders")
    public List<Order> orderV1() {
        List<Order> all = orderRepository.findAll(new OrderSearch());
        return all;
    }
}

package cashewnut.economy.user.member.repository;

import cashewnut.economy.user.member.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderSearch {

    private String memberName;
    private OrderStatus orderStatus; // [ ORDER, CANCLE ] 주문상태
}

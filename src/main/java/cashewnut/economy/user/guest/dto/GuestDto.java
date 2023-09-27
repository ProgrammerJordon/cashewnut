package cashewnut.economy.user.guest.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import org.junit.Test;

@Data
public class GuestDto {

    private String userName;
    private int age;

    public GuestDto() {
        // 기본생성자
    }

    @QueryProjection
    public GuestDto(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "GuestDto{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}

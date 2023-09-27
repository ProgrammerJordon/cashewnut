package cashewnut.economy.user.guest.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * cashewnut.economy.user.guest.dto.QGuestDto is a Querydsl Projection type for GuestDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGuestDto extends ConstructorExpression<GuestDto> {

    private static final long serialVersionUID = -1764871111L;

    public QGuestDto(com.querydsl.core.types.Expression<String> userName, com.querydsl.core.types.Expression<Integer> age) {
        super(GuestDto.class, new Class<?>[]{String.class, int.class}, userName, age);
    }

}


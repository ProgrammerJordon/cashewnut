package cashewnut.user.guest.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * cashewnut.user.guest.dto.QGuestTeamDto is a Querydsl Projection type for GuestTeamDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGuestTeamDto extends ConstructorExpression<GuestTeamDto> {

    private static final long serialVersionUID = -930804404L;

    public QGuestTeamDto(com.querydsl.core.types.Expression<Long> guestId, com.querydsl.core.types.Expression<String> userName, com.querydsl.core.types.Expression<Integer> age, com.querydsl.core.types.Expression<Long> teamId, com.querydsl.core.types.Expression<String> teamName) {
        super(GuestTeamDto.class, new Class<?>[]{long.class, String.class, int.class, long.class, String.class}, guestId, userName, age, teamId, teamName);
    }

}


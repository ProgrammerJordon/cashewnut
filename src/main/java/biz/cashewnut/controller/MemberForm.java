package biz.cashewnut.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Embedded;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberForm {
    @NotEmpty(message = "회원이름은 필수입니다.")
    private String name;
    private String city;
    private String street;
    private String zipcode;
}

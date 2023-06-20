package biz.cashewnut.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class mainEntity {
    @Id @GeneratedValue
    private Long userId;
}
package biz.cashewnut.member.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

public enum OrderStatus {
    ORDER, CANCLE
}
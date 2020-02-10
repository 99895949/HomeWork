package com.lx.parkms.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "card")
@Proxy(lazy = false)
@Data
public class Card {

    @Id
    private String cardId;

    /**
     * 停车卡主姓名
     */
    private String userName;

    /**
     * 卡主密码
     */
    private String userPassword;

    /**
     * 卡主电话
     */
    private String userPhone;

    /**
     * 卡片类型号
     */
    private Integer cardType;

    /**
     * 卡余额
     */
    private BigDecimal cardBalance;

}

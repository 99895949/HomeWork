package com.lx.parkms.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Proxy(lazy = false)
@Data
public class Charge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer chargeId;

    /**
     * 停车卡类型
     */
    private Integer cardType;

    /**
     * 车位类型
     */
    private Integer stationType;

    /**
     * 一小时多少钱
     */
    private BigDecimal price;
}

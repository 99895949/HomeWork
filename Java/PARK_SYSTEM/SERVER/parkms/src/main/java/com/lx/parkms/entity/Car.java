package com.lx.parkms.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity(name = "car")
@Proxy(lazy = false)
@Data
public class Car {

    /**
     * 车牌号
     */
    @Id
    private String carId;

    /**
     * 车型号
     */
    private String carType;

    /**
     * 所属停车卡号
     */
    private String cardId;
}

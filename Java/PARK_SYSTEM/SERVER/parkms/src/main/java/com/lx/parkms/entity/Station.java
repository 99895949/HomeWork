package com.lx.parkms.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "station")
@Proxy(lazy=false)
@Data
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stationId;

    /**
     * 车位类型号
     */
    private Integer stationType;

    /**
     * 车位位置
     */
    private String stationLocation;

    /**
     * 车位状态号
     */
    private Integer stationStatus;
}

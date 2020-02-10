package com.lx.parkms.vo;

import com.lx.parkms.entity.enums.PayStatusEnum;
import com.lx.parkms.entity.enums.PayTypeEnum;
import lombok.Data;

import java.util.Date;

@Data
public class ParkInfoVO {
    private String infoId;

    /**
     * 停车卡号
     */
    private String cardId;

    /**
     * 车主姓名
     */
    private String userName;

    /**
     * 车牌号
     */
    private String carId;

    /**
     * 车位
     */
    private String stationLocation;

    /**
     * 驶入时间
     */
    private Date beginTime;

    /**
     * 驶出时间
     */
    private Date endTime;

    /**
     * 支付方式
     */
    private Integer payType = PayTypeEnum.CARD.getCode();

    /**
     * 支付状态
     */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private String beginTimeStr;
    private String endTimeStr;
}

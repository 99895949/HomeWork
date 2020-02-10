package com.lx.parkms.entity.enums;

import lombok.Getter;

@Getter
public enum PayTypeEnum {
    CARD(0,"停车卡支付"),
    CASH(1,"现金支付");

    private Integer code;
    private String msg;

    PayTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

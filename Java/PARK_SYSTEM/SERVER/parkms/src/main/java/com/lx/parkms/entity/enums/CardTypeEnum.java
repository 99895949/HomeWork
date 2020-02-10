package com.lx.parkms.entity.enums;

/**
 * 停车卡类型
 */
public enum CardTypeEnum {
    COMMOM(0,"普通卡"),
    VIP(1,"会员卡"),
    SANKE(-1,"散客");

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    CardTypeEnum(Integer code, String msg) {

        this.code = code;
        this.msg = msg;
    }
}

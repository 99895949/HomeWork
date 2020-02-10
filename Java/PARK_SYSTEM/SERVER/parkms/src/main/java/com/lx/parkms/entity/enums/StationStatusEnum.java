package com.lx.parkms.entity.enums;

/**
 * 车位状态号
 */
public enum StationStatusEnum {
    FREE(0,"空闲"),
    OCCUPIED(1,"占用");

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    StationStatusEnum(Integer code, String msg) {

        this.code = code;
        this.msg = msg;
    }
}

package com.lx.parkms.entity.enums;

/**
 * 车位类型号
 */
public enum StationTypeEnum {
    SMALL(0,"小型车"),
    MIDDLE(1,"中型车"),
    LARGE(2,"大型车");

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

    StationTypeEnum(Integer code, String msg) {

        this.code = code;
        this.msg = msg;
    }
}

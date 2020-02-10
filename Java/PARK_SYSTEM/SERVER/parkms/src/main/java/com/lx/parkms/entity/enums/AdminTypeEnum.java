package com.lx.parkms.entity.enums;

/**
 * 管理者Type类型枚举
 */
public enum AdminTypeEnum {
    OPERATOR(0,"操作员"),
    ADMIN(1,"管理员"),
    ROOT(2,"超级管理员");

    private Integer code;

    private String msg;

    AdminTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
}

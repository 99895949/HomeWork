package com.lx.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Reader implements Serializable {

    // 主键
    private Integer id;
    // 用户名
    private String nickname;
    // 真实姓名
    private String realname;
    // 密码
    private String password;
    // 身份证号
    private String idCard;
    // 性别
    private String gender;
    // 地址
    private String address;
    // 邮箱
    private String email;
    // 联系方式
    private String telephone;
    // 读者类型
    private Integer type;

    // 读者类型字符串
    private String readerTypeStr;

    // 一个读者只能属于一个类型
    private ReaderType readerType;


}

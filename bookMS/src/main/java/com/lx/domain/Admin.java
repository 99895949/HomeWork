package com.lx.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Admin implements Serializable {
    // id
    private Integer id;
    // 用户名 唯一
    private String nickname;
    // 密码
    private String password;
    // 电话号码
    private String telephone;


}

package com.lx.parkms.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AdminVO {

    private Integer adminId;

    /**
     * 管理者姓名
     */
    private String adminName;

    /**
     * 管理者密码
     */
    private String adminPassword;

    /**
     * 管理者性别
     */
    private String adminGender;

    /**
     * 管理者电话
     */
    private String adminPhone;

    /**
     * 管理者邮箱
     */
    private String adminEmail;

    /**
     * 管理者家庭地址
     */
    private String adminAddress;

    /**
     * 管理者类型号
     */
    private Integer adminType;

    @JsonProperty("roles")
    private List<String> permissionNames;
}

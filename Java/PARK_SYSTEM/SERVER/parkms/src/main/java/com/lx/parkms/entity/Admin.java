package com.lx.parkms.entity;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="admin")
@Proxy(lazy=false)
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
}

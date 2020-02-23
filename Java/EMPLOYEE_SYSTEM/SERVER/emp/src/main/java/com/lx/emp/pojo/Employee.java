package com.lx.emp.pojo;

import lombok.Data;

@Data
public class Employee {
    private Integer empId;

    private String empName;

    private String empGender;

    private String empEmail;

    private Integer empStatus;

    private String deptId;

    private String empNo;

    // 用于序列化
    private String deptName;

    }
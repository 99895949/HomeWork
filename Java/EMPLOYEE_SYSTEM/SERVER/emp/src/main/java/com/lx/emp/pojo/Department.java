package com.lx.emp.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class Department {
    private String deptId;

    private String deptName;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date deptCreateTime;
}
package com.lx.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ReaderType implements Serializable {

    // id
    private Integer id;
    // 读者类型
    private String name;
    // 最长借阅天数
    private Integer borrowTime;

    // 一个读者类型包括很多读者
    private List<Reader> readers;
}

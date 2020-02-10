package com.lx.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Category implements Serializable {
    // 类别id
    private Integer id;
    // 类别名称
    private String name;

    // 一个类别对应多本书
    private List<Book> books;
}

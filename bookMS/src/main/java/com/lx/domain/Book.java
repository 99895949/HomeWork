package com.lx.domain;

import com.lx.util.DateUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Book implements Serializable{

    // 书在数据库的id
    private Integer id;
    // 书名
    private String name;
    // 作者
    private String author;
    // 出版社
    private String publisher;
    // 封面图片路径
    private String imagePath;
    // "isbn号
    private String isbn;
    // 价格
    private Double price;
    // 描述简介
    private String description;
    // 购买时间
    private Date buyTime;
    // 购买时间字符串
    private String buyTimeStr;
    // 状态标识，1标识已经借出去了，0标识还没借出去
    private Integer status;
    // 类别ID
    private Integer categoryID;

    // 一本书只能属于一个类别
    private Category category;

    public String getBuyTimeStr() {
        return DateUtils.format(buyTime,"yyyy-MM-DD HH:mm:ss");
    }
}

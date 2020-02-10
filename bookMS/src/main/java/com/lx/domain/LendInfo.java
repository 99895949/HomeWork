package com.lx.domain;

import com.lx.util.DateUtils;
import lombok.Data;

import java.util.Date;
@Data
public class LendInfo {
    // id
    private Integer id;
    // 书的id
    private Integer bookID;
    // 读者id
    private Integer readerID;
    // 读者真实姓名
    private String realname;
    // 书的"isbn号
    private String isbn;
    // 借阅时间
    private Date beginTime;
    // 借阅时间字符串
    private String beginTimeStr;
    // 归还时间
    private Date endTime;
    // 归还时间字符串
    private String endTimeStr;

    public String getBeginTimeStr() {
        return DateUtils.format(beginTime,"YYYY-MM-DD hh:mm:ss");
    }

    public String getEndTimeStr() {
        return DateUtils.format(endTime,"YYYY-MM-DD hh:mm:ss");
    }
}
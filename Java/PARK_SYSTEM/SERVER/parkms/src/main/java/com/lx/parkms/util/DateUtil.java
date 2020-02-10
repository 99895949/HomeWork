package com.lx.parkms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date parse(String dateString){
        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String format(Date date,String pattern){
        return new SimpleDateFormat(pattern).format(date);
    }

    // 相差多少小时
    public static double getDuring(Date begin,Date end){
        return (end.getTime() - begin.getTime()) / (1000 * 60 * 60);
    }

}

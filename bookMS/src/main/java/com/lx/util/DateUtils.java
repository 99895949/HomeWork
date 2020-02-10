package com.lx.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String format(Date date, String matches){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(matches);
        return simpleDateFormat.format(date);
    }

}

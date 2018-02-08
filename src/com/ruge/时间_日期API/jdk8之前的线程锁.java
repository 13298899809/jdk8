package com.ruge.时间_日期API;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 武健
 * \* Date: 2018/2/8
 * \* Time: 21:01
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class jdk8之前的线程锁 {

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        protected DateFormat intiValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };

    public static Date conver(String time) throws ParseException {
        return df.get().parse(time);
    }
}
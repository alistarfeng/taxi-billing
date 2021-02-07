package com.alibaba.taxibilling.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeOperateUtil {

    /**
     * 用于判断当前时间是否处于指定时间区间[dayBegin,endTime}内
     *
     * @param time      输入的用于判断的时间
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    public static boolean timeBetween(Date time, Date beginTime, Date endTime) {
        try {
            Calendar date = Calendar.getInstance();
            date.setTime(time);

            Calendar dayBegin = Calendar.getInstance();
            dayBegin.setTime(beginTime);

            Calendar dayEnd = Calendar.getInstance();
            dayEnd.setTime(endTime);
            //如果开始时间在结束时间之后增加一天
            if (dayBegin.after(dayEnd)){
                dayEnd.add(Calendar.DATE, 1);
            }
            return 0 == date.compareTo(dayBegin) || (date.after(dayBegin) && date.before(dayEnd));
        } catch (Exception e) {
            throw e;
        }

    }

    public static Date parse(String dateStr, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            Date date = df.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {

    }

}

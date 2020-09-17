package com.ranjun1999.personalutils.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Calendar类测试
 *
 * @Author: ranjun
 * @Date: 2020/7/28 14:45
 */
public class CalendarUtil {

    private Calendar calendar;

    //创建Calendar
    public Calendar getCalendar() {
        // 使用当前时间创建
        calendar = Calendar.getInstance();
        Date date = new Date();
        // 设置指定日期，月份需要减一
//        calendar.set(year, month - 1, day);
        // 指定时间创建，参数依次为：年，月，日，时，分，秒，月份需要减一
//        Calendar calendar = new GregorianCalendar(2016, 8, 1, 15, 41, 22);
        // Date转换为Calendar
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
        return calendar;
    }

    /**
     * 通过Calendar获取年月日等日期数据
     */
    public void getTime() {
        Calendar calendar = this.getCalendar();
        int year = calendar.get(Calendar.YEAR);
        // 取月份要加1
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hover = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
// 1-7分别代表 -- 星期日,星期一,星期二,星期三,星期四,星期五,星期六
        int week = calendar.get(calendar.DAY_OF_WEEK);

        //获取当前月份最大天数
        int monMaxiMum = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
        System.out.println(monMaxiMum + "," + day);
    }


    public Date calendarToDate() {
        return calendar.getTime();
    }

    /**
     * 时间加减
     */
    public void timeModify() {
        calendar = Calendar.getInstance();
        print("当前时间");
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        print("增加1小时");
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        print("增加1天    ");
        calendar.add(Calendar.MONTH, 1);
        print("增加1个月");
        calendar.add(Calendar.YEAR, 1);
        print("增加1年    ");
        calendar.add(Calendar.YEAR, -2);
        print("减少2年    ");
    }

    private void print(String name) {
        System.out.print(name + "；");
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));
    }

    public void getDiffBetweenCalendar() throws ParseException {
        getCalendar();

        long millisOfDay = 24 * 60 * 60 * 1000;
        Calendar calendar = new GregorianCalendar(2015, 9, 1);
        Calendar calendar1 = new GregorianCalendar(2016, 9, 1);
        Calendar calendar2 = new GregorianCalendar(2017, 9, 1);
        // 2016年是闰年，得到366天
        System.out.println((calendar1.getTimeInMillis() - calendar.getTimeInMillis()) / (millisOfDay));
        // 2017年是平年，得到365天
        System.out.println((calendar2.getTimeInMillis() - calendar1.getTimeInMillis()) / (millisOfDay));
    }
    public static void main(String[] args) throws ParseException {
        new CalendarUtil().getDiffBetweenCalendar();
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simple.parse("2017-12-10");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH) + 1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
}

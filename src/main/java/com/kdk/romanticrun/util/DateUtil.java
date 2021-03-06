package com.kdk.romanticrun.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    /**
     * 根据年月获取当月最后一天
     * @param yearmonth yyyy-MM
     * @return yyyy-MM-dd
     * @throws ParseException
     */
    public static String getLastDayOfMonth(String yearmonth) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            Date dd = format.parse(yearmonth);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dd);
            int cc=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            String result = yearmonth+"-"+cc;
            return result;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 时间戳转换成日期格式字符串
     * @param seconds 精确到秒的字符串
     * @param format 为null时默认yyyy-MM-dd HH:mm:ss
     * @return 返回日期字符串
     */
    public static String timeStamp2Date(String seconds,String format) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }

        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        //Date是精确到毫秒的13位时间戳,所以秒要*1000
        Date date = new Date(Long.valueOf(seconds+"000"));
        String dateString = sdf.format(date);
        return dateString;
    }

    /**
     * 日期格式字符串转换成时间戳
     * @param date_str 字符串日期
     * @param format 默认：yyyy-MM-dd HH:mm:ss
     * @return 精确到秒的时间戳
     */
    public static String date2TimeStamp(String date_str,String format){
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime()/1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 取得当前时间戳（精确到秒）
     * @return
     */
    public static String getNowTimeStamp(){
        long time = System.currentTimeMillis();
        String timestamp = String.valueOf(time/1000);
        return timestamp;
    }
}

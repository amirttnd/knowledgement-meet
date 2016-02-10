package com.tothenew.intellimeet.util;

import com.tothenew.intellimeet.domain.Intellimeet;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    static Calendar cal = Calendar.getInstance();
    final static int MONTH = cal.get(Calendar.MONTH) + 1;
    final static int YEAR = cal.get(Calendar.YEAR);

    private static Date getLastSaturday(int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 1);
        cal.add(Calendar.DAY_OF_MONTH, -(cal.get(Calendar.DAY_OF_WEEK) % 7));
        return cal.getTime();
    }

    public static Date getLastSaturdayOfCurrentMonth() {
        return converInDDMMYYYformat(getLastSaturday(MONTH, YEAR));
    }

    public static Date getLastSaturdayOfIntellimeet() {
        Date lastSaturday = getLastSaturday(MONTH, YEAR);
        if (!lastSaturday.after(new Date())) {
            lastSaturday = getLastSaturday(MONTH + 1, YEAR);
        }
        return converInDDMMYYYformat(lastSaturday);
    }

    public static Date converInDDMMYYYformat(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Timestamp toTimestamp(Date date) {
        return new Timestamp(date.getTime());

    }

    public static Integer getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH);
    }

    public static Integer getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    public static Integer getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }

    public static Integer getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static Integer getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static  Date parseDate(String date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.parse(date);

        } catch (Exception e) {

        }
        return null;
    }

    public Boolean isValidDate(String date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            simpleDateFormat.parse(date);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

}

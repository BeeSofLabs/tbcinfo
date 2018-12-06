package com.beelabs.tbcinfo.util;

import android.content.Context;


import com.beelabs.tbcinfo.IConfig;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class DateUtil {

    public static Date convertFromString(String dateString) throws ParseException {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        Calendar cal = Calendar.getInstance(tz);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf.setCalendar(cal);
        cal.setTime(sdf.parse(dateString));
        Date date = cal.getTime();

        return date;
    }

    public static Date convertToDate(long epoch) {
        return new Date((epoch) * 1000L);
    }

    public static Calendar convertToCalendar(long epoch) {
        Date date = new Date(epoch * 1000L);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);            // set hour to midnight
        cal.set(Calendar.MINUTE, 0);                 // set minute in hour
        cal.set(Calendar.SECOND, 0);                 // set second in minute
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    public static long convertToEpoch(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);            // set hour to midnight
        cal.set(Calendar.MINUTE, 0);                 // set minute in hour
        cal.set(Calendar.SECOND, 0);                 // set second in minute
        cal.set(Calendar.MILLISECOND, 0);
        return (cal.getTimeInMillis() / 1000) + 86400;
    }

    public static long convertToEpochAfternoon(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);            // set hour to midnight
        cal.set(Calendar.MINUTE, 0);                 // set minute in hour
        cal.set(Calendar.SECOND, 0);                 // set second in minute
        cal.set(Calendar.MILLISECOND, 0);
        return (cal.getTimeInMillis() / 1000) + 86400;
    }

    public static String formatString(Date date) {
        SimpleDateFormat form = new SimpleDateFormat("dd MMMM yyyy");
        String format = form.format(date);
        return format;
    }

    public static String formatStringWithDay(Date date, Context context) {
        SimpleDateFormat form = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        String format = form.format(date);
        String[] part = format.split(",");

        String dayLabel = "";
        for (String day : IConfig.daylabels) {
            String[] labels = day.split("_");
            dayLabel = part[0].replaceAll(labels[0], labels[1]);
            if (!dayLabel.equals(part[0])) break;
        }

        String dateString = "";
        for (String month : IConfig.monthLabels) {
            String[] labels = month.split("_");
            dateString = part[1].replaceAll(labels[0], labels[1]);
            if (!dateString.equals(part[1])) break;
        }

        return dayLabel + ", " + dateString;
    }


    public static int getAge(Date date) {
        if (date == null) {
            return 0;
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        Calendar cal2 = Calendar.getInstance();
        int i = 0;
        while (cal1.before(cal2)) {
            cal1.add(Calendar.YEAR, 1);
            i += 1;
        }
        return i;
    }

    public static int getMonthAge(Date date) {
        Calendar sDate = Calendar.getInstance();
        Calendar eDate = Calendar.getInstance();
        sDate.setTime(date);
        eDate.setTime(new Date());
        int difInMonths = sDate.get(Calendar.MONTH) - eDate.get(Calendar.MONTH);

        return difInMonths;
    }


}

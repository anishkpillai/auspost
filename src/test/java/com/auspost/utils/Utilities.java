package com.auspost.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utilities {

    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");


    private static Date getCurrentDate() {
        Date currentDate = new Date();
        return currentDate;
    }

    public static String getALaterDateByDays(int noOfDays) {
        Calendar c = Calendar.getInstance();
        c.setTime(getCurrentDate());
        c.add(Calendar.DATE, noOfDays);
        Date getLaterDate = c.getTime();
        return dateFormat.format(getLaterDate);
    }
}

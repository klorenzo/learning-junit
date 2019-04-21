package com.kevinlorenzo.learning.junit.util;

public class DateUtil {

    public static boolean isYearLeap(int year) {
        return (((year % 4) == 0) && ((year % 100) != 0)) || ((year % 400) == 0);
    }

}
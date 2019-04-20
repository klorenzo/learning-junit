package com.kevinlorenzo.learning.junit.util;

public class StringUtil {

    public static String repeat(String text, int times) {

        if(times < 0) {
            throw new IllegalArgumentException("Negative times are not allowed.");
        }

        String result = "";

        for (int i = 0; i < times; i++) {
            result += text;
        }

        return result;

    }

    public static boolean isEmpty(String str) {
        return (str == null) || (str.trim().length() == 0);
    }

}
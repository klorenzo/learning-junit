package com.kevinlorenzo.learning.junit;

public class StringUtils {

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

}
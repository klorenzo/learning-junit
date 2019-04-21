package com.kevinlorenzo.learning.junit.util;

public class PasswordUtil {

    public enum SecurityLevel {
        WEAK, MEDIUM, STRONG
    }

    public static SecurityLevel assessPassword(String password) {

        if((password.length() < 8) || password.matches("[a-zA-Z]+")) {
            return SecurityLevel.WEAK;
        }

        if(password.matches("[a-zA-Z0-9]+")) {
            return SecurityLevel.MEDIUM;
        }

        return SecurityLevel.STRONG;

    }

}
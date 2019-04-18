package com.kevinlorenzo.learning.junit.util;

import com.kevinlorenzo.learning.junit.util.StringUtils;

public class StringUtilsManualTests {

    public static void main(String[] args) {

        // Forma manual para probar la funcionalidad, imprimiendo en STDOUT.

        String result1 = StringUtils.repeat("Hola", 3);

        if(result1.equals("HolaHolaHola")) {
            System.out.println(">>> RESULT 1: OK");
        } else {
            System.out.println(">>> RESULT 1: ERROR");
        }

        String result2 = StringUtils.repeat("Hola", 1);

        if(result2.equals("Hola")) {
            System.out.println(">>> RESULT 2: OK");
        } else {
            System.out.println(">>> RESULT 2: ERROR");
        }

        // Forma manual para probar la funcionalidad, lanzando Excepciones.

        String result1Throw = StringUtils.repeat("Hola", 3);

        if(result1Throw.equals("HolaHolaHola")) {
            System.out.println(">>> RESULT 1 Throw: OK");
        } else {
            throw new RuntimeException("ERROR");
        }

        String result2Throw = StringUtils.repeat("Hola", 1);

        if(result2Throw.equals("Hola")) {
            System.out.println(">>> RESULT 2 Throw: OK");
        } else {
            throw new RuntimeException("ERROR");
        }

        // Forma manual para probar la funcionalidad, usando un Método Assert.

        // Inline Variable

        assertEquals(StringUtils.repeat("Hola", 3), "HolaHolaHola");
        System.out.println(">>> RESULT 1 Assert: OK");

        // Not Inline Variable

        String result2Assert = StringUtils.repeat("Hola", 1);
        assertEquals(result2Assert, "Hola");
        System.out.println(">>> RESULT 2 Assert: OK");

    }

    public static void assertEquals(String actual, String expected) {
        if(!actual.equals(expected)) {
            throw new RuntimeException(actual + " not equals to expected " + expected);
        }
    }

}
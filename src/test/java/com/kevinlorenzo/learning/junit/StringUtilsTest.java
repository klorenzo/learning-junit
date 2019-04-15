package com.kevinlorenzo.learning.junit;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void repeat_string_once() {
        Assert.assertEquals("Hola", StringUtils.repeat("Hola", 1));
    }

    @Test
    public void repeat_string_multiple_times() {
        Assert.assertEquals("HolaHolaHola", StringUtils.repeat("Hola", 3));
    }

    @Test
    public void repeat_string_zero_times() {
        Assert.assertEquals("", StringUtils.repeat("Hola", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times() {
        StringUtils.repeat("Hola", -1);
    }

}
package com.kevinlorenzo.learning.junit.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void repeat_string_once() {
        Assert.assertEquals("Hola", StringUtil.repeat("Hola", 1));
    }

    @Test
    public void repeat_string_multiple_times() {
        Assert.assertEquals("HolaHolaHola", StringUtil.repeat("Hola", 3));
    }

    @Test
    public void repeat_string_zero_times() {
        Assert.assertEquals("", StringUtil.repeat("Hola", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times() {
        StringUtil.repeat("Hola", -1);
    }

    @Test
    public void true_when_string_is_empty() {
        Assert.assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void false_when_string_is_not_empty() {
        Assert.assertFalse(StringUtil.isEmpty("Kevin Lorenzo"));
    }

    @Test
    public void true_when_string_is_null() {
        Assert.assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    public void true_when_string_has_only_spaces() {
        Assert.assertTrue(StringUtil.isEmpty("   "));
    }

}
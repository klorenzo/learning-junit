package com.kevinlorenzo.learning.junit.util;

import org.junit.Assert;
import org.junit.Test;

import static com.kevinlorenzo.learning.junit.util.PasswordUtil.SecurityLevel.*;

public class PasswordUtilTest {

    @Test
    public void weak_when_has_less_than_8_characters() {
        Assert.assertEquals(WEAK, PasswordUtil.assessPassword("1234567"));
    }

    @Test
    public void weak_when_has_only_letters() {
        Assert.assertEquals(WEAK, PasswordUtil.assessPassword("abcdef"));
    }

    @Test
    public void medium_when_has_letters_and_numbers() {
        Assert.assertEquals(MEDIUM, PasswordUtil.assessPassword("abcdef123"));
    }

    @Test
    public void strong_when_has_letters_numbers_and_symbols() {
        Assert.assertEquals(STRONG, PasswordUtil.assessPassword("abcdef123&"));
    }

}
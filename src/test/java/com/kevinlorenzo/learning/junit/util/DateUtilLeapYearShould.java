package com.kevinlorenzo.learning.junit.util;

import org.hamcrest.CoreMatchers;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilLeapYearShould {

    @Test
    public void return_true_when_year_is_divisible_by_400() {
        Assert.assertThat(DateUtil.isYearLeap(1600), CoreMatchers.is(true));
        Assert.assertThat(DateUtil.isYearLeap(2000), CoreMatchers.is(true));
        Assert.assertThat(DateUtil.isYearLeap(2400), CoreMatchers.is(true));
    }

    @Test
    public void return_false_when_year_is_divisible_by_100_and_not_by_400() {
        Assert.assertThat(DateUtil.isYearLeap(1700), CoreMatchers.is(false));
        Assert.assertThat(DateUtil.isYearLeap(1800), CoreMatchers.is(false));
        Assert.assertThat(DateUtil.isYearLeap(1900), CoreMatchers.is(false));
    }

    @Test
    public void return_true_when_year_is_divisible_by_4_and_not_by_100() {
        Assert.assertThat(DateUtil.isYearLeap(1996), CoreMatchers.is(true));
        Assert.assertThat(DateUtil.isYearLeap(2004), CoreMatchers.is(true));
        Assert.assertThat(DateUtil.isYearLeap(2008), CoreMatchers.is(true));
    }

    @Test
    public void return_false_when_year_is__not_divisible_by_4() {
        Assert.assertThat(DateUtil.isYearLeap(2017), CoreMatchers.is(false));
        Assert.assertThat(DateUtil.isYearLeap(2018), CoreMatchers.is(false));
        Assert.assertThat(DateUtil.isYearLeap(2019), CoreMatchers.is(false));
    }

}
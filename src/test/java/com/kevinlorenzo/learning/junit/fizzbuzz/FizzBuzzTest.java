package com.kevinlorenzo.learning.junit.fizzbuzz;

import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzTest {

    @Test
    public void should_return_fizz_when_number_is_divisible_by_three() {
        Assert.assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
        Assert.assertEquals("Fizz", FizzBuzz.fizzBuzz(6));
    }

    @Test
    public void should_return_buzz_when_number_is_divisible_by_five() {
        Assert.assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
        Assert.assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
    }

    @Test
    public void should_return_fizz_buzz_when_number_is_divisible_by_three_and_five() {
        Assert.assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
        Assert.assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30));
    }

    @Test
    public void should_return_the_number_when_number_is_not_divisible_by_three_and_five() {
        Assert.assertEquals("2", FizzBuzz.fizzBuzz(2));
        Assert.assertEquals("16", FizzBuzz.fizzBuzz(16));
    }

}
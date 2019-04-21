package com.kevinlorenzo.learning.junit.player;

import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;

public class PlayerTest {

    @Test
    public void loses_when_dice_number_is_too_low() {
        //Dice dice = new Dice(6); It returns random values, so the test will sometimes fail.

        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(1);

        Player player = new Player(dice, 5);

        //Assert.assertEquals(false, player.play());

        Assert.assertFalse(player.play());
    }

    @Test
    public void wins_when_dice_number_is_big() {
        //Dice dice = new Dice(6); It returns random values, so the test will sometimes fail.

        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(10);

        Player player = new Player(dice, 5);

        //Assert.assertEquals(true, player.play());

        Assert.assertTrue(player.play());
    }

}
package com.techelevator;

import com.techelevator.model.Candy;
import com.techelevator.model.Gum;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CandyTest {

    @Test
    public void testConstructorForCandy(){

        String slotLocation = "A3";
        String name = "Snykkers";
        double price = 4.25;
        String type = "Candy";
        Candy candy = new Candy(slotLocation, name, price, type);

        Assert.assertEquals("Looking for the slot location for Candy: ", slotLocation, candy.getSlotLocation());
        Assert.assertEquals("Looking for the name for Candy: ", name, candy.getName());
        Assertions.assertEquals(price, candy.getPrice(), "Looking for the price for Candy: ");
        Assert.assertEquals("Looking for the type for Candy: ", type, candy.getType());
        Assert.assertEquals("Looking for the sound for Candy ", "Yummy Yummy, So Sweet!", candy.getMessage());
    }
}

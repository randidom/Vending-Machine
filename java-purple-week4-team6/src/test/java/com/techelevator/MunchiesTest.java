package com.techelevator;

import com.techelevator.model.Gum;
import com.techelevator.model.Munchies;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MunchiesTest {

    @Test
    public void testConstructor(){

        String slotLocation = "A4";
        String name = "Chippos";
        double price = 3.85;
        String type = "Munchy";
        Munchies munchies = new Munchies(slotLocation, name, price, type);

        Assert.assertEquals("Looking for the slot location for Munchy: ", slotLocation, munchies.getSlotLocation());
        Assert.assertEquals("Looking for the name for Munchy: ", name, munchies.getName());
        Assertions.assertEquals(price, munchies.getPrice(), "Looking for the price for Munchy: ");
        Assert.assertEquals("Looking for the type for Munchy: ", type, munchies.getType());
        Assert.assertEquals("Looking for the sound for Munchy: ", "Crunch Crunch, Yum!", munchies.getMessage());
    }
}

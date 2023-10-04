package com.techelevator;

import com.techelevator.model.Gum;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GumTest {

    @Test
    public void testConstructor(){

        String slotLocation = "D1";
        String name = "Tearberry";
        double price = 1.65;
        String type = "Gum";
        Gum gum = new Gum(slotLocation, name, price, type);

        Assert.assertEquals("Looking for the slot location for Gum: ", slotLocation, gum.getSlotLocation());
        Assert.assertEquals("Looking for the name for Gum: ", name, gum.getName());
        Assertions.assertEquals(price, gum.getPrice(), "Looking for the price for Gum: ");
        Assert.assertEquals("Looking for the type for Gum: ", type, gum.getType());
        Assert.assertEquals("Looking for the sound for Gum ", "Chew Chew, Yum!", gum.getMessage());
    }
}

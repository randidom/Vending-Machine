package com.techelevator;

import com.techelevator.model.Beverages;
import com.techelevator.model.Gum;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BeveragesTest {

    @Test
    public void testConstructorForBeverages(){

        String slotLocation = "B2";
        String name = "Papsi";
        double price = 3.45;
        String type = "Drink";
        Beverages drink = new Beverages(slotLocation, name, price, type);

        Assertions.assertEquals(slotLocation, drink.getSlotLocation(), "Looking for the slot location for Drink: ");
        Assertions.assertEquals(name, drink.getName(), "Looking for the name for Drink: ");
        Assertions.assertEquals(price, drink.getPrice(), "Looking for the price for Drink: ");
        Assertions.assertEquals(type, drink.getType(), "Looking for the type for Drink: ");
        Assertions.assertEquals("Glug Glug, Yum!", drink.getMessage(), "Looking for the sound for Drink ");
    }
}

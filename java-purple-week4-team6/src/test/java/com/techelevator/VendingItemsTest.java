package com.techelevator;

import com.techelevator.model.VendingItems;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VendingItemsTest {


    @Test
    public void namesOfItems() {

        VendingItems actual = new VendingItems("C3", "Moonpie", 2.95, "Candy");

        Assert.assertEquals("Are looking for the name of the snack selected: ", "Moonpie", actual.getName());
    }

    @Test
    public void testForSlotSelection() {

        VendingItems actual = new VendingItems("C3", "Moonpie", 2.95, "Candy");

        Assert.assertEquals("Are looking for the slot of the snack selected: ", "C3", actual.getSlotLocation());
    }

    @Test
    public void testForPrice() {

        VendingItems actual = new VendingItems("A1", "U-Chews", 1.65, "Gum");

        Assertions.assertEquals(1.65, actual.getPrice(), "Are looking for the price of the snack selected: ");
    }

    @Test
    public void testForType() {

        VendingItems actual = new VendingItems("C3", "Moonpie", 2.95, "Candy");

        Assert.assertEquals("Are looking for the slot of the snack selected: ", "Candy", actual.getType());
    }

    @Test
    public void testForMessages() {

        VendingItems candy = new VendingItems("C1", "Caramel Bar", 2.25, "Candy");
        VendingItems gum = new VendingItems("A1", "U-Chews", 1.65, "Gum");
        VendingItems drink = new VendingItems("A2", "Ginger Ayle", 1.85, "Drink");
        VendingItems munchy = new VendingItems("A4", "Chippos", 3.85, "Munchy");

        Assert.assertEquals("Looking for the sound of the item selected: ", "Yummy Yummy, So Sweet!", candy.getMessage());
        Assert.assertEquals("Looking for the sound of the item selected: ", "Chew Chew, Yum!", gum.getMessage());
        Assert.assertEquals("Looking for the sound of the item selected: ", "Glug Glug, Yum!", drink.getMessage());
        Assert.assertEquals("Looking for the sound of the item selected: ", "Crunch Crunch, Yum!", munchy.getMessage());
    }

    @Test
    public void testForStock() {
        VendingItems stock = new VendingItems();
        Assert.assertEquals("The max stock should only be 5", 5, stock.getMAX_STOCK());
    }


    @Test
    public void testForNullMessage() {
        VendingItems unknownItem = new VendingItems("Z2", "MysteryFood", 10.0, "UnknownType");
        String message = unknownItem.getMessage();
        Assert.assertEquals("Message needs to match the type of snack", "", message);
    }

    @Test
    public void testForSetMaxStock() {
        VendingItems item = new VendingItems("A1", "U-Chews", 1.65, "Gum");
        int expectedMaxStock = 10;
        item.setMAX_STOCK(expectedMaxStock);
        int actualMaxStock = item.getMAX_STOCK();
        Assert.assertEquals("Max stock is only up to 5 snacks", expectedMaxStock, actualMaxStock);
    }
}





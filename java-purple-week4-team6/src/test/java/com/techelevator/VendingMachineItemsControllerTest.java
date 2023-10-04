package com.techelevator;

import com.techelevator.controller.VendingMachineItemsController;
import com.techelevator.model.VendingItems;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class VendingMachineItemsControllerTest {

private VendingMachineItemsController vendingMachine;

@Before
public void setup () {
    vendingMachine = new VendingMachineItemsController();
}

    @Test
    public void parseItemTest() {
        VendingItems snack = vendingMachine.parseItems("A2, Ginger Ayle, 1.85, Drink");
        Assert.assertNotNull("Vending items not found, null result", snack);
        Assert.assertEquals("Result should only be the slot location", "A2", snack.getSlotLocation());
        Assert.assertEquals("Result should be the snack/drink name", "Ginger Ayle", snack.getName());
        Assertions.assertEquals(1.85, snack.getPrice(), "Result should only declare the price of the item");
        Assert.assertEquals("Result should be the type of snack dispensed", "Drink", snack.getType());
    }
    @Test
    public void parseItemTest_2() {
        VendingItems snack2 = vendingMachine.parseItems("D1, Teaberry, 1.65, Gum");
        Assert.assertNotNull("Vending items not found, null result", snack2);
        Assert.assertEquals("Result should only be the slot location", "D1", snack2.getSlotLocation());
        Assert.assertEquals("Result should be the snack/drink name", "Teaberry", snack2.getName());
        Assertions.assertEquals(1.65, snack2.getPrice(), "Result should only declare the price of the item");
        Assert.assertEquals("Result should be the type of snack dispensed", "Gum", snack2.getType());
    }
    @Test
    public void loadItemsTestSlotLocation () {
        List<VendingItems> items = vendingMachine.loadItems();
        Assert.assertNotNull("Vending items not found, null result", items);
        //Testing the index and the content within the index location
        VendingItems snack = items.get(0);
        Assert.assertNotNull("The slot location is not found, and therefore null.", snack);
        Assert.assertEquals("This should display only the slot location", "A1", snack.getSlotLocation());
        Assert.assertEquals("This should only display the name", "U-Chews", snack.getName());
        Assertions.assertEquals(1.65, snack.getPrice(), "Result should only be the price amount");
        Assert.assertEquals("This should only include the type of snack", "Gum", snack.getType());

        VendingItems snack2 = items.get(1);
        Assert.assertNotNull("The name is not found, and therefore null.", snack2);
        Assert.assertEquals("This should display only the name", "A2", snack2.getSlotLocation());
        Assert.assertEquals("This should only display the name", "Ginger Ayle", snack2.getName());
        Assertions.assertEquals(1.85, snack2.getPrice(), "This should only contain the price");
        Assert.assertEquals("This should only include the type of snack", "Drink", snack2.getType());

    }

}


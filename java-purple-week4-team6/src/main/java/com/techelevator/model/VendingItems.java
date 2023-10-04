package com.techelevator.model;

import com.techelevator.controller.VendingMachineItemsController;

public class VendingItems {
    private String name;
    private double price;
    private int MAX_STOCK = 5;
    private String type;
    private String slotLocation;

    public VendingItems(String slotLocation, String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.slotLocation = slotLocation;
    }

    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }

    public int getMAX_STOCK() {
        return MAX_STOCK;
    }

    public void setMAX_STOCK(int MAX_STOCK) {
        this.MAX_STOCK = MAX_STOCK;
    }

    public String getType() {
        return type;
    }


    public String getSlotLocation() {
        return slotLocation;
    }



    public String getMessage() {
        if (getType().equals("Candy")) {
            return "Yummy Yummy, So Sweet!";
        } else if (getType().equals("Munchy")) {
            return "Crunch Crunch, Yum!";
        } else if (getType().equals("Gum")) {
        return "Chew Chew, Yum!";
        } else if ((getType().equals("Drink"))){
        return "Glug Glug, Yum!";
        }

        return "";
    }

    public VendingItems() {
    }
}

package com.techelevator.controller;

import com.techelevator.model.Candy;
import com.techelevator.model.VendingItems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineItemsController {


    public List<VendingItems> loadItems() {


        File inputFile = new File("main.csv");
        List<VendingItems> items = new ArrayList<>();

        try {
            Scanner input = new Scanner(inputFile);
            while (input.hasNextLine()) {
                String nextLine = input.nextLine();
//
                VendingItems result = parseItems(nextLine);
                items.add(result);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    public VendingItems parseItems(String line) {

        String[] values = line.split(",");

        String slotLocation = values[0].trim();
        String name = values[1].trim();
        Double price = Double.parseDouble(values[2].trim());
        String type = values[3].trim();

        VendingItems currentItem = new VendingItems(slotLocation, name, price,type);


            return currentItem;

    }
}


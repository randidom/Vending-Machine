package com.techelevator.view;



import com.techelevator.model.VendingItems;

import java.io.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.text.NumberFormat;


public class Menu {
    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "(1) Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "(2) Purchase";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE};
    private double currentMoney = 0.00;


    public void displayMainMenu() {
        System.out.println("Please Select an Option: ");
        System.out.println("-----------------------");
        System.out.println(MAIN_MENU_OPTION_DISPLAY_ITEMS);
        System.out.println(MAIN_MENU_OPTION_PURCHASE);
        System.out.println("(3) Exit");
    }

    public void displayPurchaseMenu() {
        NumberFormat number = NumberFormat.getCurrencyInstance(); //Creates USD money format
        String money = number.format(currentMoney);
        System.out.println("Current Money Balance: " +  money);
        System.out.println("----------------------");
        System.out.println("Please Select an Option: ");
        System.out.println("----------------------");
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");


    }


    public String getMainMenuChoice(Scanner scanner) {
        //String choice = scanner.nextLine();
        do {
            String choice = scanner.nextLine();

            if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {
                return choice;
            } else {
                System.out.println("ERROR ERROR: Please enter either 1, 2, or 3.");
            }
        } while (true); // Loop will repeat until a valid choice is entered
    }


    public void feedMoney(Scanner scanner) {
        boolean moneyInput = false;

        while (!moneyInput) {
            try {
                System.out.println("How much money would you like to enter? ");
                String dollarsEntered = scanner.nextLine();
                Integer dollarAmount = Integer.parseInt(dollarsEntered);
                currentMoney += dollarAmount;
                transactionalLogs("FEED MONEY", dollarAmount, currentMoney);
                moneyInput = true;
            } catch (NumberFormatException e) {
                System.out.println("ERROR ERROR: Please enter a whole number for dollars.");
            }
        }

    }

    public void selectProduct(Scanner scanner, List<VendingItems> snacks) {
        int priceTracker = 0;

        System.out.println("Available Items:");
        for (VendingItems list : snacks) {
            System.out.println((list.getSlotLocation() + ": " + list.getName() + " $" + list.getPrice()) + " |We have " + list.getMAX_STOCK() + " left in stock.");

        }
        System.out.println("-------------------------");
        System.out.println("Please enter the item key: ");
        String itemNumber = scanner.nextLine();
        VendingItems result = new VendingItems();

        for (VendingItems slot : snacks) {
            if (slot.getSlotLocation().equals(itemNumber)) {
                result = slot;
                break;
            }
        }
        if (result.getSlotLocation() == null || result.getMAX_STOCK() < 1) {
            System.out.println("Im Sorry, What you have entered is either not valid, or Item is OUT OF STOCK.... Returning to the Purchase Menu.");

        } else if (itemNumber.equals(result.getSlotLocation())) { // Need to find price with selected itemNumber from user
            result.getPrice();
            if (result.getPrice() > currentMoney) {  // No negative values
                System.out.println("Insufficient Funds. Please enter more money.");

            } else if (priceTracker % 2 == 1) { //BOGO sale
                double discountPrice = result.getPrice() - 1.00;
                currentMoney = currentMoney - discountPrice;
                transactionalLogs(result.getName(), result.getPrice(), currentMoney);
            } else {
                currentMoney = currentMoney - result.getPrice();
                // Decrease stock count by 1
                int currentStock = result.getMAX_STOCK() - 1;
                result.setMAX_STOCK(currentStock);
                priceTracker++; //Keeps track of purchase amount for BOGO sale
                System.out.println("Please Enjoy your " + result.getName() + " ..." + result.getMessage());
                transactionalLogs(result.getName(), result.getPrice(), currentMoney);
            }

        }

    }


    public void finishTransaction(Scanner scanner) {
        BigDecimal priorMoney = new BigDecimal(currentMoney);
        BigDecimal nickel = new BigDecimal("0.05");
        BigDecimal dime = new BigDecimal("0.10");
        BigDecimal quarter = new BigDecimal("0.25");

        BigDecimal currentMoneyBigDecimal = new BigDecimal(currentMoney);

        // Calculate the number of quarters needed and the remaining amount after using quarters
        int quarters = currentMoneyBigDecimal.divide(quarter, 0, RoundingMode.DOWN).intValue();
        BigDecimal remainingAmountAfterQuarters = currentMoneyBigDecimal.remainder(quarter);

        int dimes = remainingAmountAfterQuarters.divide(dime, 0, RoundingMode.DOWN).intValue();
        BigDecimal remainingAmountAfterDimes = remainingAmountAfterQuarters.remainder(dime);

        int nickels = remainingAmountAfterDimes.divide(nickel, 0, RoundingMode.UP).intValue();

        System.out.println("Don't Forget Your Change!");
        System.out.println("Dispensing change of: ");
        System.out.println("Quarters: " + quarters);
        System.out.println("Dimes: " + dimes);
        System.out.println("Nickels: " + nickels);

        //Converts prior Money back to double for the transactionLog method parameters to work
        double priorMoneyDouble = priorMoney.doubleValue();

        // Set the currentMoney to zero since all change is returned to the customer
        currentMoney = 0;

        // Log the transaction with the amount before and after giving change
        transactionalLogs("GET CHANGE", priorMoneyDouble, currentMoney);


    }

    public void transactionalLogs(String event, double amountSpent, double newBalance) {
        try (FileWriter logs = new FileWriter("Log.txt", true)) { //File Writer writes directly into files and allowed us to append
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
            String formattedDateTime = now.format(formatter);
            logs.write(formattedDateTime + " " + event + ": $" + String.format("%.2f", amountSpent) + " $" + String.format("%.2f", newBalance) + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to the log file " + e.getMessage());

        }
    }
}
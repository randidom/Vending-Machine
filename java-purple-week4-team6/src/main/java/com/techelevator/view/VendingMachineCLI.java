package com.techelevator.view;

// Menu is provided to you as a suggested class to handle user input
// Build out a menu class to start

import com.techelevator.model.VendingItems;
import com.techelevator.controller.VendingMachineItemsController;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "(1) Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "(2) Purchase";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE};
    private double CURRENT_MONEY_PROVIDED = 0.00;


    private double newBalance;
    private int dollarsInserted;

    private Menu menu;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public static void main(String[] args) {
        // You will need to create a Menu class to handle display.
        //Menu menu = new Menu();
        Menu menu = new Menu();
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }


    public void run() {
        File outputFile = new File("main.csv");
        VendingMachineItemsController controller = new VendingMachineItemsController();

        List<VendingItems> snacks;
        snacks = controller.loadItems();
        boolean stay = true;

        while (stay) {
            Scanner scanner = new Scanner(System.in);
            menu.displayMainMenu();
            String choice = menu.getMainMenuChoice(scanner);

            if (choice.equals("1")) {
                for (VendingItems list : snacks) {
                    System.out.println(list.getSlotLocation() + ": " + list.getName() + " $" + list.getPrice() + " |We have " + list.getMAX_STOCK() + " left in stock");

                }
                System.out.println("------------------------");
                continue;
            }
            while (choice.equals("2")) {
                menu.displayPurchaseMenu();
                String userInput = scanner.nextLine();
                if (userInput.equals("1")) {
                    menu.feedMoney(scanner);
                } else if (userInput.equals("2")) {
                    menu.selectProduct(scanner, snacks);
                } else if (userInput.equals("3")) {
                    menu.finishTransaction(scanner);
                    break;
                }
            }
            System.out.println("Thank you for shopping with us!");
                break;
            }

        }
    }







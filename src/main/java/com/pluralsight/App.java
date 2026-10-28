package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Item> inventory = getInventory();

        displayMenu();

    }

    private static ArrayList<Item> getInventory() {
        ArrayList<Item> inventory = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("items-list.csv"));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split("\\|");

                Item item = new Item(Integer.parseInt(fields[0]), fields[1], Double.parseDouble(fields[2]));
                inventory.add(item);

                bufferedWriter.write(item.getItemSku() + " | " + item.getItemName() + " | " + item.getItemPrice() + "\n");
            }

            bufferedReader.close();
            bufferedWriter.close();

        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println("Unable to read file. Please ensure file is in the correct location and try again.");
        }


        return inventory;
    }

    private static void printInventory() {
        System.out.println("Inventory List: ");
        System.out.println("----------");

        for (Item item : getInventory()) {
            System.out.printf("SKU: %d | Name: %s | Price: %.2f%n", item.getItemSku(), item.getItemName(), item.getItemPrice());
            System.out.println("----------");
        }
    }

    private static void displayMenu() {
//        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                What would you like to do?
                1 - List all products
                2 - Lookup a product by it's ID
                3 - Find all products within a price range
                4 - Add a new product
                5 - Quit the application
                
                Enter command: """);

        String choice = scanner.nextLine();

        while (!choice.equals("5")) {
            switch (choice) {
                case "1" -> printInventory();
                case "2":
                    System.out.println("Enter the item ID: ");
                    int itemId = scanner.nextInt();
                    scanner.next();
                    searchItems(itemId);
                    break;
                case "3":
                    findInRange(promptUserMin(), promptUserMax()); // Find a way to return a filtered down arraylist
                    break;
                case "4":
                    System.out.println("Enter the SKU: ");
                    int itemSku = scanner.nextInt();
                    scanner.next();

                    System.out.println("Enter the item name: ");
                    String item
                    addItem();

            }
        }
    }

    private static Item searchItems(int sku) {

    }

    private static double promptUserMin() {
        System.out.println("Enter minimum price: ");
        double minPrice = scanner.nextDouble();
        scanner.next();

        return minPrice;
    }

    private static double promptUserMax() {
        System.out.println("Enter the maximum price: ");
        double maxPrice = scanner.nextDouble();
        scanner.next();

        return maxPrice;
    }

    private static void findInRange(double min, double max) {
//        if (min > max) {
//            double temp = min;
//            min = max;
//            max = temp;
//        }

        for (Item item : getInventory()) {
            if (item.getItemPrice() >= min || item.getItemPrice() <= max) {

            }
        }
    }
}
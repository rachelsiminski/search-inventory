package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        ArrayList<Item> inventory = getInventory();

        printInventory();

        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("items-list.csv"));

    }

    public static ArrayList<Item> getInventory() {
        ArrayList<Item> inventory = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split("\\|");

                Item item = new Item(Integer.parseInt(fields[0]), fields[1], Double.parseDouble(fields[2]));

            }
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println("Unable to read file. Please ensure file is in the correct location and try again.");
        }

        return inventory;
    }

    public static void printInventory() {
        System.out.println("Inventory List: ");
        System.out.println("----------");

        for (Item item : getInventory()) {
            System.out.printf("SKU: %d | Name: %s | Price: %.2f%n", item.getItemSku(), item.getItemName(), item.getItemPrice());
            System.out.println("----------");
        }
    }
}
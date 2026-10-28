package com.pluralsight;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        ArrayList<Item> inventory = getInventory();

        printInventory();
    }

    public static ArrayList<Item> getInventory() {
        ArrayList<Item> inventory = new ArrayList<>();

        Item item1 = new Item(1, "Apple", .99);
        Item item2 = new Item(2, "Pear", 1.99);
        Item item3 = new Item(3, "Orange", .89);
        Item item4 = new Item(4, "Banana", .39);
        Item item5 = new Item(5, "Kiwi", .39);

        inventory.add(item1);
        inventory.add(item2);
        inventory.add(item3);
        inventory.add(item4);
        inventory.add(item5);

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
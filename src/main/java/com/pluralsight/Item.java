package com.pluralsight;

public class Item {

    private int itemSku;
    private String itemName;
    private double itemPrice;

    public Item(int itemSku, String itemName, double itemPrice) {
        this.itemSku = itemSku;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public int getItemSku() {
        return itemSku;
    }

    public void setItemSku(int itemSku) {
        this.itemSku = itemSku;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}

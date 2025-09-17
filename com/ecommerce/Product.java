package com.ecommerce;

public class Product {
    private int productID;
    private String name;
    private float price;
    private int stock;

    public int getID() {
        return this.productID;
    }

    public void setID(int newID) {
        this.productID = newID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float newPrice) {
        this.price = newPrice;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int newStock) {
        this.stock = newStock;
    }

    public static void displayTest() {
        System.out.println("Testing packages");
    }

}

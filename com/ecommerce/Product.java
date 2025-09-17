package com.ecommerce;

import java.util.HashMap;
import java.util.List;

public class Product {
    private int productID;
    private String name;
    private double price;
    private int stock; // number of units available

    private static HashMap<Integer, Object> idMap;

    public Product(String newName, double newPrice, int newStock) {
        int newID = idMap.size();
        idMap.put(newID, this);

        this.productID = newID;
        this.name = newName;
        this.price = newPrice;
        this.stock = newStock;
    }

    public int getID() {
        return this.productID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int newStock) {
        this.stock = newStock;
    }

    public static double getPriceByID(int id){
        idMap.forEach( (k ,v) -> {
            if (k == id) {
                return v.getPrice();
            }
        });
    }

    public static void displayTest() {
        System.out.println("Testing packages");
    }

}

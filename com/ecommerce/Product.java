package com.ecommerce;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product {
    private int productID;
    private String name;
    private double price;
    private int stock; // number of units available

    // Class variable to track all the instances.
    private static HashMap<Integer, Product> idMap = new HashMap<>();

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

    public static HashMap getIdMap() {
        return idMap;
    }

    public static double getPriceByID(int id) {
        Product prod = idMap.get(id);
        return prod.getPrice();
    }

    public static String getNameByID(int id) {
        Product prod = idMap.get(id);
        return prod.getName();
    }

    public static void showCatalog() {
        System.out.println("Catalog");
        System.out.println(" ID |   Name   | Units available | Price");

        for (Map.Entry<Integer, Product> entry: idMap.entrySet()) {
            System.out.println(entry.getValue().getID() + "   |" + entry.getValue().getName() + "  |  " + entry.getValue().getStock() + "        | " + entry.getValue().getPrice() + " |");
        }
    }
}

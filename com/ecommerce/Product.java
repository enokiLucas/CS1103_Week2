package com.ecommerce;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class from the package com.ecommerce.
 * Has the relevant attributes for a product
 * and the methods for its function.
 * Represents a product in an E-commerce application
 *
 * @author Lucas Enoki Pereira da Silva
 */
public class Product {
    // Instances variables
    private int productID;
    private String name;
    private double price;
    private int stock; // number of units available

    // Class variable to track all the instances.
    private static HashMap<Integer, Product> idMap = new HashMap<>();

    /**
     * Class constructor
     *
     * @param newName the name of the product
     * @param newPrice the price of the product
     * @param newStock how much units are available
     */
    public Product(String newName, double newPrice, int newStock) {
        // Provides a new Id for each new instance that is plus one from the previous one.
        int newID = idMap.size();
        idMap.put(newID, this);

        this.productID = newID;
        this.name = newName;
        this.price = newPrice;
        this.stock = newStock;
    }

    // Getter and Setter methods for each instance.
    /**
     * Getter method for productID
     *
     * @return the id for the product
     */
    public int getID() {
        return this.productID;
    }

    /**
     * Getter method for name
     *
     * @return the name for the product
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter method for price
     *
     * @return the price for the product
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Getter method for stock
     *
     * @return the stock for the product
     */
    public int getStock() {
        return this.stock;
    }

    /**
     * Setter method for stock
     *
     * @param newStock the new amount available
     */
    public void setStock(int newStock) {
        this.stock = newStock;
    }

    /**
     * Class method that returns the HashMap
     * that keeps track of all the instances generated
     *
     * @return the HashMap that tracks the instances
     */
    public static HashMap getIdMap() {
        return idMap;
    }

    /**
     * Class method that will get the attribute 'price'
     * from an instance, using the instance id as an argument.
     *
     * @param id the id of an instance of this Class
     * @return the price attribute from the instance
     */
    public static double getPriceByID(int id) {
        Product prod = idMap.get(id);
        return prod.getPrice();
    }

    /**
     * Class method that will get the attribute 'name'
     * from an instance, using the instance id as an argument.
     *
     * @param id the id of an instance of this Class
     * @return the name attribute from the instance
     */
    public static String getNameByID(int id) {
        Product prod = idMap.get(id);
        return prod.getName();
    }

    /**
     * Class method that creates a catalog for the user
     * containing all the attributes of each variable in a
     * easy way for the user.
     */
    public static void showCatalog() {
        System.out.println("Catalog");
        System.out.println(" ID |   Name   | Units available | Price");

        for (Map.Entry<Integer, Product> entry: idMap.entrySet()) {
            System.out.println(entry.getValue().getID() + "   |" + entry.getValue().getName() + "  |  " + entry.getValue().getStock() + "        | " + entry.getValue().getPrice() + " |");
        }
    }
}

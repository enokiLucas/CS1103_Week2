package com.ecommerce;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class from the package com.ecommerce.
 * Has the relevant attributes for a product
 * and the methods for its function.
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

    // Class constructor
    public Product(String newName, double newPrice, int newStock) {
        // Provides a new Id for each new instance that is plus one from the previous one.
        int newID = idMap.size();
        idMap.put(newID, this);

        this.productID = newID;
        this.name = newName;
        this.price = newPrice;
        this.stock = newStock;
    }

    // Getter and Setter functions for each instance.
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

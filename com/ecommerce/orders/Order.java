package com.ecommerce.orders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ecommerce.Product;


/**
 * Class from the package com.ecommerce.orders
 * Has the relevant attributes for a order issued by the user
 * and the methods for its function.
 * Represents a order issued by a customer in an E-commerce application
 *
 * @author Lucas Enoki Pereira da Silva
 */
public class Order {
    // Instances attributes
    private int orderID;
    private int customer; //stores the customer ID
    private HashMap<Integer, Integer> purchases; // Map in which the keys will be the ProductID and the value will be the quantity.

    // Class variable to track all the instances.
    private static HashMap<Integer, Order> idMap = new HashMap<>();

    /**
     * Class constructor
     *
     * @param newCustomer the id of the customer
     * @param newPurchases The HashMap representing the cart
     */
    public Order(int newCustomer, HashMap newPurchases) {
        int newID = idMap.size();
        idMap.put(newID, this);

        this.orderID = newID;
        this.customer = newCustomer;
        this.purchases = newPurchases;
    }

    /**
     * Getter method for orderID
     *
     * @return the id of the order
     */
    public int getID() {
        return this.orderID;
    }

    /**
     * Getter method for customer
     *
     * @return the id of the customer that issued the order
     */
    public int getCustomer() {
        return this.customer;
    }

    /**
     * Getter method for purchases
     *
     * @return the hashmap with all the purchases
     */
    public HashMap getPurchases() {
        return this.purchases;
    }

    /**
     * Class method that returns the HashMap
     * that keeps track of all the instances generated
     *
     * @return the HashMap that tracks the instances
     */
    public static HashMap getMap() {
        return idMap;
    }

    /**
     * Similar to the catalog method from Product,
     * will generate a table with the attributes of the
     * products the user wants to buy and will calculate
     * the total amount
     */
    public void makeSummary() {
        System.out.println("Review order");
        System.out.println("ID|   Name   | Units |Individual Price||Total");
        List<Double> listTotalPerItem = new ArrayList<>();
        double orderTotal = 0;

        for (Map.Entry<Integer, Integer> entry: this.purchases.entrySet()) {
            double totalPerItem = Product.getPriceByID(entry.getKey()) * entry.getValue();

            System.out.println(entry.getKey() + "|" + Product.getNameByID(entry.getKey()) + "|" + entry.getValue() + "|" + Product.getPriceByID(entry.getKey()) + "||" + totalPerItem);
            listTotalPerItem.add(totalPerItem);
        }

        for (double price : listTotalPerItem) {
            orderTotal = orderTotal + price;
        }

        System.out.println("Total Value of the order: " + orderTotal);
    }
}

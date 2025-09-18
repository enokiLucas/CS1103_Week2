package com.ecommerce.orders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ecommerce.Product;

public class Order {
    private int orderID;
    private int customer; //stores the customer ID
    private HashMap<Integer, Integer> purchases; // Map in which the keys will be the ProductID and the value will be the quantity.

    // Class variable to track all the instances.
    private static HashMap<Integer, Order> idMap = new HashMap<>();

    public Order(int newCustomer, HashMap newPurchases) {
        int newID = idMap.size();
        idMap.put(newID, this);

        this.orderID = newID;
        this.customer = newCustomer;
        this.purchases = newPurchases;
    }

    public int getID() {
        return this.orderID;
    }

    public int getCustomer() {
        return this.customer;
    }

    public HashMap getPurchases() {
        return this.purchases;
    }

    public static HashMap getMap() {
        return idMap;
    }

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

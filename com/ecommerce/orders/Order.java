package com.ecommerce.orders;

import java.util.HashMap;

public class Order {
    private int orderID;
    private int customer; //stores the customer ID
    private HashMap purchases; // Map in which the keys will be the ProductID and the value will be the number of orders.

    public Order(int newID, int newCustomer, HashMap newPurchases) {
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
}

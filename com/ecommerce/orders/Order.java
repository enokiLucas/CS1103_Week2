package com.ecommerce.orders;

public class Order {
    private int orderID;
    private int customer; //stores the customer ID
    private int[] products; //stores multiple products ID

    public int getID() {
        return this.orderID;
    }

    public void setID() {
        this.orderID = newID;
    }

    public int getCustomer() {
        return this.customer;
    }

    public int[] getProducts() {
        return this.products;
    }
}

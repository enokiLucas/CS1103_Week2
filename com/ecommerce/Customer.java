package com.ecommerce;

public class Customer {
    private int customerID;
    private String name;
    private Map shoppingCart; // Map in which the keys will be the ProductID and the value will be the number of orders.

    public int getID() {
        return this.customerID;
    }

    public void setID(int newID) {
        this.customerID = newID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public Map getShoppingCart() {
        return this.shoppingCart;
    }

    public void setShoppingCart(Map newCart) {
        this.shoppingCart = newCart;
    }
}

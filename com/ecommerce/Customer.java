package com.ecommerce;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private int customerID;
    private String name;
    private HashMap<Integer, Integer> shoppingCart; // Map in which the keys will be the ProductID and the value will be the number of orders.
    private String email;
    private String phone;

    private static HashMap<Integer, Object> idMap;

    public Customer(String newName) {
        int newID = idMap.siza();
        idMap.put(newID, this);

        this.customerID = newID;
        idList.add(newName);
        this.name = newName;
    }

    public int getID() {
        return this.customerID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public HashMap getShoppingCart() {
        return this.shoppingCart;
    }

    public void setShoppingCart(HashMap newCart) {
        this.shoppingCart = newCart;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String newPhone) {
        this.phone = newPhone;
    }

    public void addToCart(int productID, int quantity) {
        this.shoppingCart.put(productID, quantity);
    }

    public void removeFromCart(int productID, int quantity) { // quantity to be removed, NOT the final value.
        int oldValue = this.shoppingCart.get(productID);
        if (quantity > oldValue) {
            this.shoppingCart.replace(productID, oldValue, 0);
        }
        else {
            int newValue = oldValue - quantity;
            this.shoppingCart.replace(productID, oldValue, newValue);
        }
    }

    public double getTotal(){
        double total = 0;
        for (Map.Entry<Integer, Object> entry: idMap.entrySet()) {
            double individualPrice = Product.getPriceByID(k);
            double pricePerItem = individualPrice * v;
            total = total + pricePerItem;
        }

        return total;
    }
}

package com.ecommerce;

import java.util.HashMap;
import java.util.Map;
import com.ecommerce.orders.Order;

public class Customer {
    private int customerID;
    private String name;
    private HashMap<Integer, Integer> shoppingCart; // Map in which the keys will be the ProductID and the value will be the number of orders.

    // Class variable to track all the instances.
    private static HashMap<Integer, Object> idMap = new HashMap<>();

    public Customer(String newName) {
        int newID = idMap.size();
        idMap.put(newID, this);

        this.customerID = newID;
        this.name = newName;
        this.shoppingCart = new HashMap<>();
    }

    public int getID() {
        return this.customerID;
    }

    public String getName() {
        return this.name;
    }

    public HashMap getShoppingCart() {
        return this.shoppingCart;
    }

    public void addToCart(int productID, int quantity) {
        HashMap<Integer, Product> prodMap = Product.getIdMap();
        Product prod = prodMap.get(productID);

        if (productID < 0 || productID > prodMap.size()) {
            System.out.println("You selected an id without a corresponding product, please check the catalog");
        }
        else if (quantity > prod.getStock()) {
            System.out.println("You request more than we have available, please check the catalog");
        }
        else {
            this.shoppingCart.put(productID, quantity);
        }
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
        for (Map.Entry<Integer, Integer> entry: this.shoppingCart.entrySet()) {
            double individualPrice = Product.getPriceByID(entry.getKey());
            int numbOfItems = entry.getValue();
            double pricePerItem = individualPrice * numbOfItems;
            total = total + pricePerItem;
        }

        return total;
    }

    public Order makeOrder() {
        HashMap<Integer, Product> prodMap = Product.getIdMap();

        for (Map.Entry<Integer, Integer> entry: this.shoppingCart.entrySet()) {
            Product prod = prodMap.get(entry.getKey());
            int stockOldValue = prod.getStock();
            int stockNewValue = stockOldValue - entry.getValue();
            prod.setStock(stockNewValue);
        }
        return new Order(this.getID(), this.getShoppingCart());
    }
}

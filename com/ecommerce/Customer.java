package com.ecommerce;

import java.util.HashMap;
import java.util.Map;
import com.ecommerce.orders.Order;

/**
 * Class from the package com.ecommerce.
 * Has the relevant attributes for a customer
 * and the methods for its function.
 * Represents a customer in an E-commerce application
 *
 * @author Lucas Enoki Pereira da Silva
 */
public class Customer {
    // Instances attributes
    private int customerID;
    private String name;
    private HashMap<Integer, Integer> shoppingCart; // Map in which the keys will be the ProductID and the value will be the number of orders.

    // Class variable to track all the instances.
    private static HashMap<Integer, Object> idMap = new HashMap<>();

    /**
     * Class constructor
     *
     * @param newName the name of the customer
     */
    public Customer(String newName) {
        // Provides a new Id for each new instance that is plus one from the previous one.
        int newID = idMap.size();
        idMap.put(newID, this);

        this.customerID = newID;
        this.name = newName;
        this.shoppingCart = new HashMap<>();
    }

    // Getter and setter methods
    /**
     * Getter method for customerID
     *
     * @return the id of the customer
     */
    public int getID() {
        return this.customerID;
    }

    /**
     * Getter method for name
     *
     * @return the name of the customer
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter method for shoppingCart
     *
     * @return the cart of the customer
     */
    public HashMap getShoppingCart() {
        return this.shoppingCart;
    }

    /**
     * Will add to the this.shoppingCart HashMap
     * the productID and the quantity the user wishes to buy
     * Will test if the arguments are valid.
     *
     * @param productID the id of the product the user wants to buy
     * @param quantity how much the user wants to buy
     */
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

    /**
     * Remove a item previously added in the cart.
     * Will test if the arguments are valid.
     *
     * @param productID the id of the product the user wants to remove
     * @param quantity how much the user wants to remove
     */
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

    /**
     * Calculates the total amount of
     * all the products in the cart
     *
     * @return the sum of all prices in the cart
     */
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

    /**
     * Issues an order based on the products in the cart
     * Updates the stock based on how much the user intends to buy
     * Calls the constructor of the Class Order
     *
     * @return the order created
     */
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

package org.atyeti.orderfulfillmentSystem.model;



public class Order {
    private String orderId;
    private String customerId;
    private String itemName;
    private int quantity;

    public Order(String orderId, String customerId, String itemName, int quantity) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

//Problem Statement:
//Simulate a Bank Transaction Processing System that:
//Accepts multiple bank transactions concurrently (using threads).
//Uses collections to store and analyze transactions.
//Prevents race conditions using synchronization.
//Supports analytics like top customers, total debit/credit, and duplicate detection.

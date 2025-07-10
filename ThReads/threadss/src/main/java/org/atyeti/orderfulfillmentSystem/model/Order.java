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

//Real-Time Order Fulfillment System
//Purpose:
//Simulate a warehouse/order fulfillment system where:
//
//Multiple orders arrive concurrently from customers (via threads),
//
//Items are packed and shipped from a shared inventory,
//
//Data is tracked using Java Collections, and
//
//Thread safety is ensured to avoid data corruption.

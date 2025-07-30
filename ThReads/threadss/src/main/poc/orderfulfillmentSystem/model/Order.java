package model;

public class Order {
    private String orderId;
    private String customerId;
    private String itemName;
    private int quantity;
    private String statusHint;

    public Order(String orderId, String customerId, String itemName, int quantity,String statusHint) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.statusHint=statusHint;

    }



    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatusHint() {
        return statusHint;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", statusHint='" + statusHint + '\'' +
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

package inheritance.e_Commerce_System;

public class Electronics extends Product implements Discountable {
    int warrantyPeriod;

    Electronics(String productId, String name, double price, int warrantyPeriod) {
        super(productId, name, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void applyDiscount(double percentage) {
        price -= price * (percentage / 100);
    }

    @Override
    void getProductDetails() {
        System.out.println("Electronics Product:");
        System.out.println("ID: " + productId + ", Name: " + name + ", Price: ₹" + price);
        System.out.println("Warranty: " + warrantyPeriod + " months");
    }
}
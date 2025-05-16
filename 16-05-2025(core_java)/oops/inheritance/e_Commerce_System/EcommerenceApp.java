package inheritance.e_Commerce_System;

public class EcommerenceApp {
    public static void main(String[] args) {
        Product[] products = new Product[2];

        products[0] = new Electronics("E101", "Laptop", 60000, 12);
        products[1] = new Clothing("C202", "Jacket", 2500, "M", "Leather");

        for (Product p : products) {
            if (p instanceof Discountable) {
                ((Discountable) p).applyDiscount(10); // Apply 10% discount
            }
            System.out.println("\n--- Product Details After Discount ---");
            p.getProductDetails();
        }
    }
}

package inheritance.e_Commerce_System;

public class Clothing extends Product implements Discountable {
    String size;
    String material;

    Clothing(String productId, String name, double price, String size, String material) {
        super(productId, name, price);
        this.size = size;
        this.material = material;
    }

    @Override
    public void applyDiscount(double percentage) {
        price -= price * (percentage / 100);
    }

    @Override
    void getProductDetails() {
        System.out.println("Clothing Product:");
        System.out.println("ID: " + productId + ", Name: " + name + ", Price: ₹" + price);
        System.out.println("Size: " + size + ", Material: " + material);
    }
}

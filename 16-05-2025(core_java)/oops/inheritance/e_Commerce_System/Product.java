package inheritance.e_Commerce_System;


abstract class Product {
    String productId;
    String name;
    double price;

    Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    abstract void getProductDetails();
}




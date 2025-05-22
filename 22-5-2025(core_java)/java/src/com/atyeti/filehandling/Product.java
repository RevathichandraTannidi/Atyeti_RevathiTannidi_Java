package com.atyeti.filehandling;

public class Product {
    int ProductID;
    String ProductName;
     String  Category;
      double Price;
      int Stock;

    public Product(int productID, String productName, String category, double price, int stock) {
        ProductID = productID;
        ProductName = productName;
        Category = category;
        Price = price;
        Stock = stock;
    }
    public String getProductName() {
        return ProductName;
    }

}

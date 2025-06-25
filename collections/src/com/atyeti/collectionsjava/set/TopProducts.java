package com.atyeti.collections.set;

//6. Top N Unique Products by Price Using TreeSet
// Scenario:
//From a product list, keep only top 3 highest-priced unique products (by name)

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class TopProducts {
    public static void main(String[] args) {

    List<Product> allProducts = List.of(
            new Product("Laptop", 1200),
            new Product("Phone", 800),
            new Product("Watch", 400),
            new Product("Phone", 750),
            new Product("Tablet", 600)
    );

    TreeSet<Product> top = new TreeSet<>(Comparator.comparingDouble(Product::getPrice).reversed()
            .thenComparing(Product::getName));

        for (Product p : allProducts) {
        top.add(p);
    }

        top.stream().limit(3).forEach(System.out::println);
}
}


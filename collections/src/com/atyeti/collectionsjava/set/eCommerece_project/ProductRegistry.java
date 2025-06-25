package com.atyeti.collections.set.eCommerece_project;

import java.util.HashSet;
import java.util.Set;

public class ProductRegistry {

        private final Set<Product> products = new HashSet<>();

        public boolean addProduct(Product p) {
            return products.add(p);
        }

        public void showProducts() {
            products.forEach(System.out::println);
        }
    }



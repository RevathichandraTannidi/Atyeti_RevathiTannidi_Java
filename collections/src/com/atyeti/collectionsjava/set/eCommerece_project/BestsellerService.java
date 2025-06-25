package com.atyeti.collections.set.eCommerece_project;

import java.util.Set;
import java.util.TreeSet;

public class BestsellerService {
    private final Set<ProductSale> bestsellers = new TreeSet<>();

    public void recordSale(ProductSale sale) {
        bestsellers.add(sale);
    }

    public void showTop(int n) {
        bestsellers.stream().limit(n).forEach(System.out::println);
    }
}
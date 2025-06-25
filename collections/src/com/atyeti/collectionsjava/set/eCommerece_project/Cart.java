package com.atyeti.collections.set.eCommerece_project;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Cart {
    private final Set<String> items = new CopyOnWriteArraySet<>();

    public void addItem(String item) {
        items.add(item);
    }
    public void viewItems() {
        System.out.println("cart: " + items);
    }
}


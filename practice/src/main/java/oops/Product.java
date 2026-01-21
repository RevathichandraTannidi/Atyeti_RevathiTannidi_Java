package oops;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static void main(String[] args) {
        List<Product> li =new ArrayList<>();
        li.add(new Product("book",34.0,"stationary"));
        li.add(new Product("watch",223.4,"Electronics"));
        li.add(new Product("mouse",123.4,"Electronics"));
        li.add(new Product("balm",32.3,"stationary"));
        li.add(new Product("wires",433.14,"Electronics"));
        li.add(new Product("laptop",65223.84,"Electronics"));
        li.add(new Product("clip",12.3,"stationary"));


        li.stream().filter(e->"Electronics".equalsIgnoreCase(e.getCategory())).map(Product::getName).forEach(System.out::println);
    }
}
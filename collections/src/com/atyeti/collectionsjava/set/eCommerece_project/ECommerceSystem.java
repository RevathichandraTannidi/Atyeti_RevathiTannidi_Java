package com.atyeti.collections.set.eCommerece_project;

public class ECommerceSystem {

    public static void main(String[] args) {

        ProductRegistry registry = new ProductRegistry();

        registry.addProduct(new Product("SKU123", "Laptop"));
         registry.addProduct(new Product("SKU123", "Laptop"));
    registry.addProduct(new Product("SKU456", "phone"));
        registry.showProducts();

        SearchHistory se = new SearchHistory();
         se.search("Laptop");
      se.search("phone");
      se.search("Watch");
      se.search("Shoes");
     se.search("Bag");
      se.search("Laptop");
        se.showHistory();

      DiscountService ds = new DiscountService();
      ds.applyCoupon("user1", "SAVE20");
        ds.applyCoupon("user1", "SAVE20");

   BestsellerService bs = new BestsellerService();
          bs.recordSale(new ProductSale("SKU123", 120));
            bs.recordSale(new ProductSale("SKU456", 300));
          bs.recordSale(new ProductSale("SKU789", 150));
         bs.showTop(2);

        Cart ct = new Cart();
         ct.addItem("phone");
          ct.addItem("phone");
          ct.addItem("Head phones");
           ct.viewItems();

        FeatureFlags ff = new FeatureFlags();
         ff.enable("flash-sale");
         System.out.println("Flash sale: " + ff.isEnabled("flash-sale"));
    }
}

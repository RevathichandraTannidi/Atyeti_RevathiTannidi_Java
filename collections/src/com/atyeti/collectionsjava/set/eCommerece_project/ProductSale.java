package com.atyeti.collections.set.eCommerece_project;

public class ProductSale implements Comparable<ProductSale> {
        String sku;
        int sold;

        public ProductSale(String sku, int sold) {
            this.sku = sku;
            this.sold = sold;
        }

        @Override
        public int compareTo(ProductSale o) {
            return Integer.compare(o.sold, this.sold); // descending
        }

        @Override
        public String toString() {
            return sku + " sold: " + sold;
        }
    }





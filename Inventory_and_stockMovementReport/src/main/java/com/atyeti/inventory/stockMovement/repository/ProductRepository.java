package com.atyeti.inventory.stockMovement.repository;

import com.atyeti.inventory.stockMovement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByCode(String code);
}

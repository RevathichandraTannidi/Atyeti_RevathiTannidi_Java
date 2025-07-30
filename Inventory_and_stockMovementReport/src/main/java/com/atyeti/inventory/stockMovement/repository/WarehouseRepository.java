package com.atyeti.inventory.stockMovement.repository;

import com.atyeti.inventory.stockMovement.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

}

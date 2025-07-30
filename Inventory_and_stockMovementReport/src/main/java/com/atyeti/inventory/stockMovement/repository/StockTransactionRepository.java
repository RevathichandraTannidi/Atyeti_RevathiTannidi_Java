package com.atyeti.inventory.stockMovement.repository;

import com.atyeti.inventory.stockMovement.model.StockTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StockTransactionRepository extends JpaRepository<StockTransaction, Long> {
    List<StockTransaction> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
    List<StockTransaction> findByProductCode(String productCode);

    List<StockTransaction> findByProductCodeAndWarehouseId(String productCode, Long warehouseId);
}

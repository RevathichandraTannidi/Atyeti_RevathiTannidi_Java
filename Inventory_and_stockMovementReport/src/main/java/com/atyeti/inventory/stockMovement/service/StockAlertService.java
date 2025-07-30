package com.atyeti.inventory.stockMovement.service;

import com.atyeti.inventory.stockMovement.dto.response.LowStockAlertDto;
import com.atyeti.inventory.stockMovement.model.Product;
import com.atyeti.inventory.stockMovement.model.StockTransaction;
import com.atyeti.inventory.stockMovement.repository.ProductRepository;
import com.atyeti.inventory.stockMovement.repository.StockTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StockAlertService {

    private final ProductRepository productRepo;
    private final StockTransactionRepository txnRepo;

    @Autowired
    public StockAlertService(ProductRepository productRepo,
                             StockTransactionRepository txnRepo) {
        this.productRepo = productRepo;
        this.txnRepo = txnRepo;
    }

    @Transactional(readOnly = true)
    public List<LowStockAlertDto> getLowStockAlerts() {

        List<Product> products = productRepo.findAll();

        return products.stream()
                .map(prod -> {
                    int currentStock = computeStock(prod.getCode());
                    return new LowStockAlertDto(
                            prod.getCode(),
                            prod.getWarehouse().getId().toString(),
                            currentStock,
                            prod.getReorderLevel()
                    );
                })
                .filter(dto -> dto.getCurrentStock() < dto.getReorderLevel())
                .collect(Collectors.toList());
    }

    private int computeStock(String productCode) {
        List<StockTransaction> transactions = txnRepo.findByProductCode(productCode);


        return transactions.stream()
                .mapToInt(StockTransaction::getQuantityDelta)
                .sum();
    }
}

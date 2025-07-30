package com.atyeti.inventory.stockMovement.service;
import java.io.*;
import com.atyeti.inventory.stockMovement.dto.response.ReportSummaryDto;
import com.atyeti.inventory.stockMovement.dto.response.StockLevelDto;
import com.atyeti.inventory.stockMovement.dto.response.TrendDto;
import com.atyeti.inventory.stockMovement.dto.response.LowStockAlertDto;
import com.atyeti.inventory.stockMovement.exception.ResourceNotFoundException;
import com.atyeti.inventory.stockMovement.model.Product;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;

import com.atyeti.inventory.stockMovement.model.StockTransaction;
import com.atyeti.inventory.stockMovement.repository.ProductRepository;
import com.atyeti.inventory.stockMovement.repository.StockTransactionRepository;
import com.atyeti.inventory.stockMovement.repository.ReportJobStatusRepository;
import com.atyeti.inventory.stockMovement.model.ReportJobStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final StockTransactionRepository txnRepo;
    private final ProductRepository productRepo;
    private final ReportJobStatusRepository statusRepo;

    @Autowired
    public ReportService(
            StockTransactionRepository txnRepo,
            ProductRepository productRepo,
            ReportJobStatusRepository statusRepo) {
        this.txnRepo = txnRepo;
        this.productRepo = productRepo;
        this.statusRepo = statusRepo;
    }

    @Transactional(readOnly = true)
    public ReportSummaryDto buildReportSummary(String jobId) {
        ReportJobStatus status = statusRepo.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job", jobId));

        if (!"COMPLETED".equals(status.getStatus())) {
            throw new IllegalStateException("Report job not completed yet: " + jobId);
        }

        List<StockTransaction> txns = txnRepo.findAll();

        // 1. Compute current stock levels
        Map<String, Integer> stockMap = new HashMap<>();
        for (StockTransaction txn : txns) {
            String key = txn.getProduct().getCode() + "|" + txn.getWarehouse().getId();
            stockMap.merge(key, txn.getQuantityDelta(), Integer::sum);
        }
        List<StockLevelDto> stockLevels = stockMap.entrySet().stream()
                .map(e -> {
                    String[] parts = e.getKey().split("\\|");
                    return new StockLevelDto(parts[0], parts[1], e.getValue());
                })
                .collect(Collectors.toList());

        // 2. Compute movement trends (last 7 days)
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime weekAgo = now.minusDays(7);
        List<StockTransaction> recent = txnRepo.findByTimestampBetween(weekAgo, now);
        Map<String, long[]> trendsAcc = new HashMap<>();
        for (StockTransaction txn : recent) {
            String prodCode = txn.getProduct().getCode();
            long[] arr = trendsAcc.computeIfAbsent(prodCode, k -> new long[2]);
            if (txn.getQuantityDelta() > 0) arr[0] += txn.getQuantityDelta();
            else arr[1] += -txn.getQuantityDelta();
        }
        List<TrendDto> trends = trendsAcc.entrySet().stream()
                .map(e -> new TrendDto(
                        e.getKey(),
                        weekAgo.toLocalDate() + " to " + now.toLocalDate(),
                        e.getValue()[0],
                        e.getValue()[1]))
                .collect(Collectors.toList());

        // 3. Produce low stock alerts
        List<Product> allProducts = productRepo.findAll();
        List<LowStockAlertDto> alerts = new ArrayList<>();
        for (Product p : allProducts) {
            int current = stockLevels.stream()
                    .filter(sl -> sl.getProductCode().equals(p.getCode()))
                    .mapToInt(StockLevelDto::getCurrentStock)
                    .findFirst()
                    .orElse(0);
            if (current < p.getReorderLevel()) {
                alerts.add(new LowStockAlertDto(
                        p.getCode(),
                        p.getWarehouse().getId().toString(),
                        current,
                        p.getReorderLevel()));
            }
        }

        return new ReportSummaryDto(stockLevels, trends, alerts);
    }
    public ResponseEntity<Resource> getReportFile(String jobId) throws IOException {
        ReportJobStatus status = statusRepo.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job", jobId));

        if (!"COMPLETED".equals(status.getStatus())) {
            throw new IllegalStateException("Report job not completed: " + jobId);
        }

        // Locate file on disk
        Path file = Paths.get("reports", jobId + "_report.csv");
        if (!Files.exists(file)) {
            throw new FileNotFoundException("Report file not found for jobId " + jobId);
        }

        InputStreamResource resource = new InputStreamResource(Files.newInputStream(file));

        return ResponseEntity.ok()
                .contentLength(Files.size(file))
                .contentType(MediaType.parseMediaType("text/csv"))
                .header("Content-Disposition", "attachment; filename=\"" + file.getFileName().toString() + "\"")
                .body(resource);
    }
    public void anotherHelperMethod() {

    }
}

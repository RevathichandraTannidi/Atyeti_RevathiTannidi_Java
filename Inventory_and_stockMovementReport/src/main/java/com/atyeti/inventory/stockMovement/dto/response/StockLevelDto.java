package com.atyeti.inventory.stockMovement.dto.response;

public class StockLevelDto {
    private String productCode;
    private String warehouseId;
    private int currentStock;

    public StockLevelDto() {}
    public StockLevelDto(String productCode, String warehouseId, int currentStock) {
        this.productCode = productCode;
        this.warehouseId = warehouseId;
        this.currentStock = currentStock;
    }
    // Getters and setters
    public String getProductCode() { return productCode; }
    public String getWarehouseId() { return warehouseId; }
    public int getCurrentStock() { return currentStock; }
    public void setProductCode(String productCode) { this.productCode = productCode; }
    public void setWarehouseId(String warehouseId) { this.warehouseId = warehouseId; }
    public void setCurrentStock(int currentStock) { this.currentStock = currentStock; }
}
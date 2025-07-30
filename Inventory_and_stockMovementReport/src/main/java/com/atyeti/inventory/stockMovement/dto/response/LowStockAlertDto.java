package com.atyeti.inventory.stockMovement.dto.response;



public class LowStockAlertDto {
    private String productCode;
    private String warehouseId;
    private int currentStock;
    private int reorderLevel;

    public LowStockAlertDto() {}
    public LowStockAlertDto(String productCode, String warehouseId, int currentStock, int reorderLevel) {
        this.productCode = productCode;
        this.warehouseId = warehouseId;
        this.currentStock = currentStock;
        this.reorderLevel = reorderLevel;
    }
    // Getters and setters...
    public String getProductCode() { return productCode; }
    public String getWarehouseId() { return warehouseId; }
    public int getCurrentStock() { return currentStock; }
    public int getReorderLevel() { return reorderLevel; }
    public void setProductCode(String productCode) { this.productCode = productCode; }
    public void setWarehouseId(String warehouseId) { this.warehouseId = warehouseId; }
    public void setCurrentStock(int currentStock) { this.currentStock = currentStock; }
    public void setReorderLevel(int reorderLevel) { this.reorderLevel = reorderLevel; }
}

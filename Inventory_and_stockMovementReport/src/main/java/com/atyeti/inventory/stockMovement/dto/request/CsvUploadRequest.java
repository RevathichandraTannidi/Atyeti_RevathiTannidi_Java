package com.atyeti.inventory.stockMovement.dto.request;

import org.springframework.web.multipart.MultipartFile;

public class CsvUploadRequest {
    private MultipartFile file;
    private String warehouseId;

    public CsvUploadRequest() {}
    public CsvUploadRequest(MultipartFile file, String warehouseId) {
        this.file = file;
        this.warehouseId = warehouseId;
    }
    public MultipartFile getFile() { return file; }
    public void setFile(MultipartFile file) { this.file = file; }
    public String getWarehouseId() { return warehouseId; }
    public void setWarehouseId(String warehouseId) { this.warehouseId = warehouseId; }
}

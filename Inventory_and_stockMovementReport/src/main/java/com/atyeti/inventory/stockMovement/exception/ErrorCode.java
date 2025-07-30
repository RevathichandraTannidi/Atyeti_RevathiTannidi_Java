package com.atyeti.inventory.stockMovement.exception;

public enum ErrorCode {
    RESOURCE_NOT_FOUND(404, "Resource not found"),
    FILE_PROCESSING_ERROR(500, "Error processing CSV file"),
    INVALID_CSV_FORMAT(400, "Invalid CSV format"),
    INTERNAL_ERROR(500, "Internal server error");

    private final int status;
    private final String message;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() { return status; }
    public String getMessage() { return message; }
}


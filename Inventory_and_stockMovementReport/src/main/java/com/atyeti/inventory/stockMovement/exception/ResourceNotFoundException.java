package com.atyeti.inventory.stockMovement.exception;

public class ResourceNotFoundException extends ApplicationException {
    public ResourceNotFoundException(String resource, String id) {
        super(ErrorCode.RESOURCE_NOT_FOUND, resource + " not found: " + id);
    }
}


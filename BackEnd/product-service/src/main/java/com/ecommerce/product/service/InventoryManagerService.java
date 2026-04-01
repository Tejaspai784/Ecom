package com.ecommerce.product.service;

public interface InventoryManagerService {
    boolean reserveStock(String sku, Integer quantity);
    void updateStock(String sku, Integer newQuantity);
}
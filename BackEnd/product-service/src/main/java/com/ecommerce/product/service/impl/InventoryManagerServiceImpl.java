package com.ecommerce.product.service.impl;

import com.ecommerce.product.service.InventoryManagerService;
import com.ecommerce.product.repository.InventoryRepository;
import com.ecommerce.product.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryManagerServiceImpl implements InventoryManagerService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    @Transactional
    public boolean reserveStock(String sku, Integer quantity) {
        Inventory inventory = inventoryRepository.findBySku(sku)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (inventory.getCurrentStock() >= quantity) {
            inventory.setCurrentStock(inventory.getCurrentStock() - quantity);
            inventory.setReservedStock(inventory.getReservedStock() + quantity);
            inventoryRepository.save(inventory);
            return true;
        }
        return false;
    }

    @Override
    public void updateStock(String sku, Integer newQuantity) {
        // logic for manual stock update
    }
}
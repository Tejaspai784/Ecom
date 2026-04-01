package com.ecommerce.product.controller;

import com.ecommerce.product.service.InventoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryManagerService inventoryService;

    @PostMapping("/reserve")
    public boolean reserve(@RequestParam String sku, @RequestParam Integer quantity) {
        return inventoryService.reserveStock(sku, quantity);
    }
}
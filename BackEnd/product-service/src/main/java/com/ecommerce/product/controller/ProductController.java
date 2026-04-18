package com.ecommerce.product.controller;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.service.ProductCatalogService;
import com.ecommerce.common.dto.ProductCreationDTO; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductCatalogService productCatalogService;

    @GetMapping
    public List<Product> getAll() {
        return productCatalogService.getAllProducts();
    }

    @GetMapping("/{sku}")
    public Product getProduct(@PathVariable String sku) {
        return productCatalogService.getProductBySku(sku);
    }

    @PostMapping
     public Product create(@RequestBody ProductCreationDTO dto) {
        return productCatalogService.createProduct(dto);
    }
    
    @PutMapping("/{sku}")
    public Product update(@PathVariable String sku, @RequestBody Product product) {
        return productCatalogService.updateProduct(sku, product);
    }

    @DeleteMapping("/{sku}")
    public String delete(@PathVariable String sku) {
        productCatalogService.deleteProduct(sku);
        return "Product with SKU " + sku + " has been soft-deleted.";
    }
}
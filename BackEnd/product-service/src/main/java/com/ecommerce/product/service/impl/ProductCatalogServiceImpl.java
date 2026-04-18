package com.ecommerce.product.service.impl;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.model.Inventory;
import com.ecommerce.product.repository.ProductRepository;
import com.ecommerce.product.repository.InventoryRepository;
import com.ecommerce.product.repository.CategoryRepository;
import com.ecommerce.product.service.ProductCatalogService;
import com.ecommerce.common.dto.ProductCreationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional; 
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

    @Autowired
    private ProductRepository productRepository;
     @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product getProductBySku(String sku) {
        return productRepository.findBySku(sku).orElseThrow(() -> new RuntimeException("Product not found with SKU: " + sku));
    }

    @Override
    public Product createProduct(ProductCreationDTO dto) {
    Product product = new Product();
    product.setSku(dto.getSku());
    product.setName(dto.getName());
    product.setDescription(dto.getDescription());
    product.setPrice(dto.getPrice());
    product.setCategoryId(dto.getCategoryId());
    Product savedProduct = productRepository.save(product);

    Inventory inventory = new Inventory();
    inventory.setSku(savedProduct.getSku());
    inventory.setCurrentStock(dto.getInitialStock());
    inventory.setReservedStock(0);
    inventoryRepository.save(inventory);
    categoryRepository.findById(Objects.requireNonNull(dto.getCategoryId())).orElseThrow(() -> new RuntimeException("Cannot create product: Category ID " + dto.getCategoryId() + " does not exist"));
    return savedProduct;
}

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public Product updateProduct(String sku, Product details) {
        Product existingProduct = getProductBySku(sku);
        existingProduct.setName(details.getName());
        existingProduct.setDescription(details.getDescription());
        existingProduct.setPrice(details.getPrice());
        existingProduct.setCategoryId(details.getCategoryId());
        return productRepository.save(existingProduct);
    }

    @Override
    @Transactional
    public void deleteProduct(String sku) {
        Product product = getProductBySku(sku);
        product.setSoftDeleted(true);
        product.setSoftDeletedAt(new java.util.Date());
        productRepository.save(product);
    }
}
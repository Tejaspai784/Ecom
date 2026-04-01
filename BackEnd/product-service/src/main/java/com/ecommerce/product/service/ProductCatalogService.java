package com.ecommerce.product.service;

import com.ecommerce.product.model.Product;
import java.util.List;

public interface ProductCatalogService {
    Product getProductBySku(String sku);
    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product updateProduct(String sku, Product productDetails);
    void deleteProduct(String sku);
}
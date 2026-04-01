package com.ecommerce.product.model;

import com.ecommerce.common.model.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "inventory")
@Getter @Setter
public class Inventory extends BaseModel {
    private String sku; // Matches Product SKU
    private Integer currentStock;
    private Integer reservedStock;
}
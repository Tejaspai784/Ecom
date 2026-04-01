package com.ecommerce.product.model;

import com.ecommerce.common.model.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter @Setter
public class Product extends BaseModel {
    private String sku;
    private String name;
    private String description;
    private BigDecimal price;
    private Long categoryId;
}
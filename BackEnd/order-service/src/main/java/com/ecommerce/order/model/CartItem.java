package com.ecommerce.order.model;

import com.ecommerce.common.model.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cart_items")
@Getter @Setter
public class CartItem extends BaseModel {
    private Long cartId; // Links to the Cart entity
    private String sku;
    private Integer quantity;
}
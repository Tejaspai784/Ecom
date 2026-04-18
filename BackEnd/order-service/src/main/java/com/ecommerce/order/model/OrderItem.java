package com.ecommerce.order.model;

import com.ecommerce.common.model.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Getter @Setter
public class OrderItem extends BaseModel {
    private String orderId;
    private String sku;
    private Integer quantity;
    private BigDecimal unitPrice;
}
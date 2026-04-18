package com.ecommerce.order.model;

import com.ecommerce.common.model.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order extends BaseModel {
    private String userId;
    private BigDecimal totalAmount;
    private String status; 
}
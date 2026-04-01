package com.ecommerce.common.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderPlacedEvent {
    private String orderId;
    private String userId;
    private List<CartItemDTO> items;
    private BigDecimal totalAmount;
}
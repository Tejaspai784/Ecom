package com.ecommerce.common.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDetailsDTO {
    private String orderId;
    private String status;
    private BigDecimal totalAmount;
    private List<CartItemDTO> items;
}
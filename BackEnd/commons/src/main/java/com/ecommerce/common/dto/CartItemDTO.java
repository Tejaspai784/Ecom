package com.ecommerce.common.dto;

import lombok.Data;

@Data
public class CartItemDTO {
    private String sku;
    private Integer quantity;
}
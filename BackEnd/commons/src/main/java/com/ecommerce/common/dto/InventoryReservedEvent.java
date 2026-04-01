package com.ecommerce.common.dto;

import lombok.Data;

@Data
public class InventoryReservedEvent {
    private String orderId;
    private boolean success;
    private String message;
}
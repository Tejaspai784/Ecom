package com.ecommerce.common.dto;

import lombok.Data;

@Data
public class PaymentResultEvent {
    private String orderId;
    private String transactionId;
    private boolean success;
    private String failureReason;
}
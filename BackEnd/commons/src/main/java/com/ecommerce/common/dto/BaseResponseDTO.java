package com.ecommerce.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponseDTO<T> {
    private boolean success;
    private int statusCode;
    private String message;
    private T data; // Added to hold the actual object/list returned
}
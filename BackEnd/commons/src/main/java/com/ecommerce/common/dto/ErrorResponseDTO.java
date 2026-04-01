package com.ecommerce.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDTO {
    private int httpStatusCode;
    private String errorCode;
    private String errorDetails;
    private String timestamp;
}
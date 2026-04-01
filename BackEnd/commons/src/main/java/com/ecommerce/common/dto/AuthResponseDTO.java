package com.ecommerce.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponseDTO {
    private String jwtToken;
    private Long expirationTimestamp;
}
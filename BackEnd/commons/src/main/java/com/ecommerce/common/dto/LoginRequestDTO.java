package com.ecommerce.common.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String username; // Usually the email
    private String password;
}
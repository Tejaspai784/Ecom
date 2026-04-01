package com.ecommerce.common.dto;

import lombok.Data;

@Data
public class RegistrationDTO {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
}
package com.ecommerce.common.dto;

import lombok.Data;

@Data
public class ProfileUpdateDTO {
    private String firstName;
    private String lastName;
    private String profileUrl;
}
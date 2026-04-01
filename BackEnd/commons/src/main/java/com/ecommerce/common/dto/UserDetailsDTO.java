package com.ecommerce.common.dto;

import lombok.Data;
import java.util.Set;

@Data
public class UserDetailsDTO {
    private String userId;
    private String email;
    private Set<String> roles; // e.g., ["ROLE_USER", "ROLE_ADMIN"]
}
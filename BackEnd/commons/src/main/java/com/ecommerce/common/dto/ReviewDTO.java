package com.ecommerce.common.dto;

import lombok.Data;

@Data
public class ReviewDTO {
    private String productId;
    private Integer rating; // 1 to 5
    private String comment;
    private String userId;
}
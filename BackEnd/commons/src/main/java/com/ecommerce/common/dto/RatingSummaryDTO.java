package com.ecommerce.common.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class RatingSummaryDTO {
    private String productId;
    private BigDecimal averageRating;
    private Long reviewCount;
}
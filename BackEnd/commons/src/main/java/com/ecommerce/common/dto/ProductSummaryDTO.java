package com.ecommerce.common.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductSummaryDTO {
    private String sku;
    private String name;
    private BigDecimal price;
    private String imageUrl; // For the thumbnail
}
package com.ecommerce.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreationDTO {
    private String sku; // Optional: depending on if you generate it or provide it
    private String name;
    private String description;
    private BigDecimal price;
    private Long categoryId;
    private Integer initialStock; // Flows to the Inventory table
}
package com.ecommerce.common.dto;

import lombok.Data;
import java.util.List;

@Data
public class SearchResponseDTO {
    private PaginationDTO pagination;
    private List<ProductSummaryDTO> results;
}
package com.ecommerce.common.dto;

import lombok.Data;
import java.util.List;

@Data
public class SearchRequestDTO {
    private String queryText;
    private List<String> categoryFilters;
    private String sortField; // e.g., "price" or "name"
    private String sortOrder; // e.g., "ASC" or "DESC"
}
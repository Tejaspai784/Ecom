package com.ecommerce.common.dto;

import lombok.Data;

@Data
public class PaginationDTO {
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
}
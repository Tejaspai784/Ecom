package com.ecommerce.product.model;

import com.ecommerce.common.model.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter @Setter
public class Category extends BaseModel {
    private String name;
}
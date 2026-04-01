package com.ecommerce.order.model;

import com.ecommerce.common.model.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "carts")
@Getter @Setter
public class Cart extends BaseModel {
    private String userId;
    private Date lastUpdated;
}
package com.ecommerce.user.model;

import com.ecommerce.common.model.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter @Setter
public class User extends BaseModel {
    @Column(unique = true, nullable = false)
    private String email;
    private String phone;
    private String hashedPassword;
    private boolean enabled = true;
}
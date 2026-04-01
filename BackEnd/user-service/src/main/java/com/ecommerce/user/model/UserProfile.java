package com.ecommerce.user.model;

import com.ecommerce.common.model.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_profiles")
@Getter @Setter
public class UserProfile extends BaseModel {
    private Long userId;
    private String firstName;
    private String lastName;
    private String profileUrl;
}
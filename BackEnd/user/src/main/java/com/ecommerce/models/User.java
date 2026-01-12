package com.ecommerce.models;

// import java.util.List;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
public class User {
  private Long Id;
  private String userName;
  private String firstName;
  private String lastName;
  private String email;
  // private List<Address> addresses ;
}

package com.ecommerce.services;

import java.util.List;

import com.ecommerce.models.User;

public interface IUserService {
    User getUserById(Long id);
    User getUserByEmail(String email);
    User getUserByUserName(String userName);
    User getUserByFirstName(String firstName);
    User getUserByLastName(String lastName);
    User getUserByAddress(String address);
    User getUserByRole(String role);
    User getUserByStatus(String status);
    User getUserByCreatedAt(String createdAt);
    User getUserByUpdatedAt(String updatedAt);
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(User user);
    List<User> getAllUsers();
    
}

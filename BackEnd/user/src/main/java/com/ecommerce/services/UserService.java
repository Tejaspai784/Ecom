package com.ecommerce.services;

import java.util.List;

import com.ecommerce.models.User;

public class UserService {
    private IUserService userService;
    public UserService(IUserService userService) {
        this.userService = userService;
    }
    public User getUserById(Long id) {
        return userService.getUserById(id);
    }
    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }
    public User getUserByUserName(String userName) {
        return userService.getUserByUserName(userName);
    }
    public User getUserByFirstName(String firstName) {
        return userService.getUserByFirstName(firstName);
    }
    public User getUserByLastName(String lastName) {
        return userService.getUserByLastName(lastName);
    }
    public User getUserByAddress(String address) {
        return userService.getUserByAddress(address);
    }
    public User getUserByRole(String role) {
        return userService.getUserByRole(role);
    }
    public User getUserByStatus(String status) {
        return userService.getUserByStatus(status);
    }
    public User getUserByCreatedAt(String createdAt) {
        return userService.getUserByCreatedAt(createdAt);
    }
    public User getUserByUpdatedAt(String updatedAt) {
        return userService.getUserByUpdatedAt(updatedAt);
    }
    public User saveUser(User user) {
        return userService.saveUser(user);
    }
    public User updateUser(User user) {
        return userService.updateUser(user);
    }
    public void deleteUser(User user) {
        userService.deleteUser(user);
    }
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}

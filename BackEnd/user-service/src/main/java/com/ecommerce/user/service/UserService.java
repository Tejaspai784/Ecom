package com.ecommerce.user.service;

import com.ecommerce.user.model.User;

public interface UserService {
    User registerUser(User user);
    User getUserByEmail(String email);
}
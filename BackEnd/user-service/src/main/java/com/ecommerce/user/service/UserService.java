package com.ecommerce.user.service;

import com.ecommerce.common.dto.RegistrationDTO;
import com.ecommerce.user.model.User;
import com.ecommerce.user.model.UserProfile;

public interface UserService {
    User registerUser(RegistrationDTO registrationDto); 
    User getUserByEmail(String email);
    UserProfile getUserProfile(Long userId);
}
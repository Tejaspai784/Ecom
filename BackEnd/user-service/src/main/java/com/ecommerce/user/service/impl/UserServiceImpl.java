package com.ecommerce.user.service.impl;

import com.ecommerce.common.dto.RegistrationDTO;
import com.ecommerce.user.model.User;
import com.ecommerce.user.model.UserProfile;
import com.ecommerce.user.repository.UserRepository;
import com.ecommerce.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.ecommerce.user.repository.UserProfileRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;
    @Override
    @Transactional
    public User registerUser(RegistrationDTO dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setHashedPassword(dto.getPassword());
        User savedUser = userRepository.save(user);
        UserProfile profile = new UserProfile();
        profile.setUserId(savedUser.getId());
        profile.setFirstName(dto.getFirstName());
        profile.setLastName(dto.getLastName());
        userProfileRepository.save(profile);

        return savedUser;
    }

    @Override
    public User getUserByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email)).orElse(null);
    }

    @Override
    public UserProfile getUserProfile(Long userId) {
        return userProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Profile not found for user ID: " + userId));
    }
}
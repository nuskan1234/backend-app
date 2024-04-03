package com.restaurent.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Users registerUser(Users user) {
        // Check if the email is already registered
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }
        // Your implementation for user registration
        return userRepository.save(user);
    }

    public String loginUser(String email, String password) {
        // Find user by email
        if (userRepository.existsByEmailAndPassword(email, password)) {
            return "Login successful!";
        } else {
            return "Incorrect username or password!";
        }
    }

    public Users getUserById(int userId) {
        // Find user by ID
        return userRepository.findById(userId).orElse(null);
    }

    public Users updateUserProfile(int userId, Users user) {
        // Find existing user by ID
        Users existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser == null) {
            throw new RuntimeException("User not found");
        }
        // Update user profile
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setNumber(user.getNumber());
        existingUser.setAddress(user.getAddress());
        return userRepository.save(existingUser);
    }

    public void logoutUser(int userId) {
        // Your implementation for user logout
        // This could involve clearing any session data or token associated with the user
        // depending on your authentication mechanism
    }
}

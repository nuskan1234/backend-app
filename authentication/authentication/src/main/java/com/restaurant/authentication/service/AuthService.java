package com.restaurant.authentication.service;

import com.restaurant.authentication.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    public String login(String name, String password) {
        // Implement authentication logic here
        // For simplicity, let's just return a success message if credentials match
        if (authRepository.existsByNameAndPassword(name, password)) {
            return "Login successful!";
        } else {
            return "Incorrect username or password!";
        }
    }
}

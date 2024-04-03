package com.restaurant.authentication.controller;

import com.restaurant.authentication.repository.Auth;
import com.restaurant.authentication.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String loginUser(@RequestBody Auth auth) {

        return authService.login(auth.getName(), auth.getPassword());
    }
}

package com.restaurent.users;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("*")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user) {

        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody Users users) {

        return userService.loginUser(users.getName(), users.getPassword());
    }

    @GetMapping("/{userId}")
    public Users getUserById(@PathVariable int userId) {

        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    public Users updateUserProfile(@PathVariable int userId, @RequestBody Users user) {
        return userService.updateUserProfile(userId, user);
    }

    @PostMapping("/logout")
    public void logoutUser(@RequestParam int userId) {
        userService.logoutUser(userId);
    }
}

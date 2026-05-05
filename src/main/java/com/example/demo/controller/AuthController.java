package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userRepo.findByEmail(user.getEmail())
                .filter(u -> u.getPassword().equals(user.getPassword()))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}
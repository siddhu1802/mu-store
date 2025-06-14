package com.mustore.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mustore.store.model.User;
import com.mustore.store.repositories.UserRepository;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest) {
        System.out.println("Login attempt: email=" + loginRequest.getEmail() + ", pass=" + loginRequest.getPass());
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user != null) {
            System.out.println("User found: email=" + user.getEmail() + ", pass=" + user.getPass());
        } else {
            System.out.println("User not found for email: " + loginRequest.getEmail());
        }
        if (user != null && user.getPass().equals(loginRequest.getPass())) {
            return ResponseEntity.ok(user.getEmail());
        } else {
            return ResponseEntity.status(401).body("Invalid username or password.");
        }
    }


}
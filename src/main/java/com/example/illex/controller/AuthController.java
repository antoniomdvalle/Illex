package com.example.illex.controller;

import org.springframework.web.bind.annotation.*;

import com.example.illex.dto.auth.LoginRequest;
import com.example.illex.dto.auth.RegisterRequest;
import com.example.illex.model.User;
import com.example.illex.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request){
        authService.register(request);
        return "User registered sucessfully";
    }

    @PostMapping("/login")
    public User login(@Valid @RequestBody LoginRequest request){
        return authService.login(request);
    }
}

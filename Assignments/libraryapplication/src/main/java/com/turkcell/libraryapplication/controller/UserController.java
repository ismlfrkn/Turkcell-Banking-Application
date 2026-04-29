package com.turkcell.libraryapplication.controller;

import com.turkcell.libraryapplication.dto.request.LoginRequest;
import com.turkcell.libraryapplication.dto.request.RegisterRequest;
import com.turkcell.libraryapplication.dto.response.LoginResponse;
import com.turkcell.libraryapplication.dto.response.RegisterResponse;
import com.turkcell.libraryapplication.service.UserServiceImpl;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(
            @Valid @RequestBody RegisterRequest request) {

        return ResponseEntity.ok(
                userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request) {

        return ResponseEntity.ok(
                userService.login(request));
    }
}
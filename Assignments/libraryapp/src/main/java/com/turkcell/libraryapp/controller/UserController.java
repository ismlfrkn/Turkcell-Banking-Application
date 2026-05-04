package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.user.request.LoginRequest;
import com.turkcell.libraryapp.dto.user.request.RegisterRequest;
import com.turkcell.libraryapp.dto.user.response.LoginResponse;
import com.turkcell.libraryapp.dto.user.response.RegisteredUserResponse;
import com.turkcell.libraryapp.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public RegisteredUserResponse register(@Valid @RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return userService.login(request);
    }
}
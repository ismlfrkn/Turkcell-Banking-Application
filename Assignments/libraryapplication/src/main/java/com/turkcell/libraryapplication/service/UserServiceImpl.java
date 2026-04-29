package com.turkcell.libraryapplication.service;

import com.turkcell.libraryapplication.dto.request.LoginRequest;
import com.turkcell.libraryapplication.dto.request.RegisterRequest;
import com.turkcell.libraryapplication.dto.response.LoginResponse;
import com.turkcell.libraryapplication.dto.response.RegisterResponse;
import com.turkcell.libraryapplication.entity.User;
import com.turkcell.libraryapplication.exception.InvalidCredentialsException;
import com.turkcell.libraryapplication.exception.UserAlreadyExistsException;
import com.turkcell.libraryapplication.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException();
        }

        User user = new User();
        user.setEmail(request.getEmail());

        // HASHLEME
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole("USER");

        userRepository.save(user);

        return new RegisterResponse("Kayıt işlemi başarıyla tamamlandı.");
    }

    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new InvalidCredentialsException());

        // HASH KARŞILAŞTIRMA
        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        )) {
            throw new InvalidCredentialsException();
        }

        return new LoginResponse("Giriş işlemi başarıyla tamamlandı.");
    }
}
package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.exception.InvalidCredentialsException;
import com.turkcell.libraryapp.exception.UserAlreadyExistsException;
import com.turkcell.libraryapp.dto.user.request.LoginRequest;
import com.turkcell.libraryapp.dto.user.request.RegisterRequest;
import com.turkcell.libraryapp.dto.user.response.LoginResponse;
import com.turkcell.libraryapp.dto.user.response.RegisteredUserResponse;
import com.turkcell.libraryapp.entity.User;
import com.turkcell.libraryapp.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisteredUserResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.email())) {
            throw new UserAlreadyExistsException();
        }

        User user = new User();
        user.setEmail(request.email());

        String hashedPassword = passwordEncoder.encode(request.password());
        user.setPasswordHash(hashedPassword);

        User savedUser = userRepository.save(user);

        return new RegisteredUserResponse(
                savedUser.getUserId(),
                savedUser.getEmail()
        );
    }

    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.email())
                .orElseThrow(InvalidCredentialsException::new);

        boolean passwordMatches = passwordEncoder.matches(
                request.password(),
                user.getPasswordHash()
        );

        if (!passwordMatches) {
            throw new InvalidCredentialsException();
        }

        return new LoginResponse(
                user.getUserId(),
                user.getEmail(),
                "Giriş başarılı."
        );
    }
}
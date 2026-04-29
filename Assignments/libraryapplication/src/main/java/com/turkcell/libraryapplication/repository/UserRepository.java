package com.turkcell.libraryapplication.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.libraryapplication.entity.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User,UUID> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);


}

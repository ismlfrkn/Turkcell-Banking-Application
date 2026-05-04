package com.turkcell.libraryapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.libraryapp.entity.Mudur;

public interface MudurRepository extends JpaRepository<Mudur, UUID> {

}

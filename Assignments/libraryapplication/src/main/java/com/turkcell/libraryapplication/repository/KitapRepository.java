package com.turkcell.libraryapplication.repository;

import com.turkcell.libraryapplication.entity.Kitap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KitapRepository extends JpaRepository<Kitap, UUID> {
}

package com.turkcell.libraryapplication.repository;

import com.turkcell.libraryapplication.entity.Yazar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface YazarRepository extends JpaRepository<Yazar, UUID> {
}

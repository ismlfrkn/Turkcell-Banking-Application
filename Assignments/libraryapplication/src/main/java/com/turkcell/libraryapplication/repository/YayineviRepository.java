package com.turkcell.libraryapplication.repository;

import com.turkcell.libraryapplication.entity.Yayinevi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface YayineviRepository extends JpaRepository<Yayinevi, UUID> {
}

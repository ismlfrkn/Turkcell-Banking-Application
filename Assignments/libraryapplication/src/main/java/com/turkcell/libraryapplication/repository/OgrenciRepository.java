package com.turkcell.libraryapplication.repository;

import com.turkcell.libraryapplication.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OgrenciRepository extends JpaRepository<Ogrenci, UUID> {
}

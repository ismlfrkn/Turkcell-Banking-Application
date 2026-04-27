package com.turkcell.libraryapplication.repository;

import com.turkcell.libraryapplication.entity.Personel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonelRepository extends JpaRepository<Personel, UUID> {
}

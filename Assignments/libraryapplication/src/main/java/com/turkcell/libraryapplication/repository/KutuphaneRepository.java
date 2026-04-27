package com.turkcell.libraryapplication.repository;

import com.turkcell.libraryapplication.entity.Kutuphane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KutuphaneRepository extends JpaRepository<Kutuphane, UUID> {
}

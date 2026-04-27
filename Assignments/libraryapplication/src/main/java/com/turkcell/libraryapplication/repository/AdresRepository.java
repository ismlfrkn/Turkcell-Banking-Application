package com.turkcell.libraryapplication.repository;

import com.turkcell.libraryapplication.entity.Adres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresRepository extends JpaRepository<Adres, Integer> {
}

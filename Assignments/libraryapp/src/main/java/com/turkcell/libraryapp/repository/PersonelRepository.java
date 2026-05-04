package com.turkcell.libraryapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.libraryapp.entity.Personel;

public interface PersonelRepository extends JpaRepository<Personel, UUID> {

}

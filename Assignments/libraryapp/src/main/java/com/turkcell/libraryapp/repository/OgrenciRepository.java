package com.turkcell.libraryapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.libraryapp.entity.Ogrenci;

public interface OgrenciRepository extends JpaRepository<Ogrenci, UUID> {

}

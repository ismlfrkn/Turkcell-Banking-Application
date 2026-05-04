package com.turkcell.libraryapp_cqrs.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.libraryapp_cqrs.entity.Personel;

public interface PersonelRepository extends JpaRepository<Personel, UUID> {

}

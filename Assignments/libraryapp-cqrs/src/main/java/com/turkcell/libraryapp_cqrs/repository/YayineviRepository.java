package com.turkcell.libraryapp_cqrs.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.libraryapp_cqrs.entity.Yayinevi;

public interface YayineviRepository extends JpaRepository<Yayinevi, UUID> {

}

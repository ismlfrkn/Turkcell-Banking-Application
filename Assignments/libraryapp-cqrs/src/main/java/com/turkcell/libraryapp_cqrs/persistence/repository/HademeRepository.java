package com.turkcell.libraryapp_cqrs.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.libraryapp_cqrs.domain.Hademe;


public interface HademeRepository extends JpaRepository<Hademe, UUID> {

}

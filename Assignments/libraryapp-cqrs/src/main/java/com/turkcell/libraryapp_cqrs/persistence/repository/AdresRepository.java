package com.turkcell.libraryapp_cqrs.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.libraryapp_cqrs.domain.Adres;

public interface AdresRepository extends JpaRepository<Adres,Integer> {

}

package com.turkcell.libraryapp_cqrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.libraryapp_cqrs.entity.Adres;

public interface AdresRepository extends JpaRepository<Adres,Integer> {

}

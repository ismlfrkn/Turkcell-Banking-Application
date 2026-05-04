package com.turkcell.libraryapp_cqrs.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.libraryapp_cqrs.entity.Kutuphane;

public interface KutuphaneRepository extends JpaRepository<Kutuphane, UUID> {

}

package com.turkcell.libraryapp_cqrs.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.libraryapp_cqrs.domain.KutuphaneSorumlusu;

public interface KutuphaneSorumlusuRepository extends JpaRepository<KutuphaneSorumlusu, UUID> {

}

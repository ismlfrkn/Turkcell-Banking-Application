package com.turkcell.libraryapp_cqrs.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.libraryapp_cqrs.domain.KutuphaneOgrenci;

import java.util.UUID;

public interface KutuphaneOgrenciRepository extends JpaRepository<KutuphaneOgrenci, UUID> {

    boolean existsByKutuphane_KutuphaneIdAndOgrenci_OgrenciId(UUID kutuphaneId, UUID ogrenciId);

    boolean existsByKartNo(String kartNo);
}
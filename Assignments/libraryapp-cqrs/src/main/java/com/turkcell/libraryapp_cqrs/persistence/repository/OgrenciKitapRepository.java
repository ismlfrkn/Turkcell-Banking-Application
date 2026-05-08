package com.turkcell.libraryapp_cqrs.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.libraryapp_cqrs.domain.OgrenciKitap;

import java.util.UUID;

public interface OgrenciKitapRepository extends JpaRepository<OgrenciKitap, UUID> {

    boolean existsByOgrenci_OgrenciIdAndKutuphaneKitap_KutuphaneKitapIdAndIadeDurumuFalse(
            UUID ogrenciId,
            UUID kutuphaneKitapId
    );
}
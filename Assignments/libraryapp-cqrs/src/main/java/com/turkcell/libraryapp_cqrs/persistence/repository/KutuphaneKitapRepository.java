package com.turkcell.libraryapp_cqrs.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.libraryapp_cqrs.domain.KutuphaneKitap;

import java.util.Optional;
import java.util.UUID;

public interface KutuphaneKitapRepository extends JpaRepository<KutuphaneKitap, UUID> {

    boolean existsByKutuphane_KutuphaneIdAndKitap_KitapId(UUID kutuphaneId, UUID kitapId);

    Optional<KutuphaneKitap> findByKutuphane_KutuphaneIdAndKitap_KitapId(UUID kutuphaneId, UUID kitapId);
}
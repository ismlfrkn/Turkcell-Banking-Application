package com.turkcell.libraryapp.repository;

import com.turkcell.libraryapp.entity.KutuphaneKitap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface KutuphaneKitapRepository extends JpaRepository<KutuphaneKitap, UUID> {

    boolean existsByKutuphane_KutuphaneIdAndKitap_KitapId(UUID kutuphaneId, UUID kitapId);

    Optional<KutuphaneKitap> findByKutuphane_KutuphaneIdAndKitap_KitapId(UUID kutuphaneId, UUID kitapId);
}
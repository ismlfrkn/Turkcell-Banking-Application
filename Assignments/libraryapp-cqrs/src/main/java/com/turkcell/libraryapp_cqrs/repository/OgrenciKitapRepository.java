package com.turkcell.libraryapp_cqrs.repository;

import com.turkcell.libraryapp_cqrs.entity.OgrenciKitap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OgrenciKitapRepository extends JpaRepository<OgrenciKitap, UUID> {

    boolean existsByOgrenci_OgrenciIdAndKutuphaneKitap_KutuphaneKitapIdAndIadeDurumuFalse(
            UUID ogrenciId,
            UUID kutuphaneKitapId
    );
}
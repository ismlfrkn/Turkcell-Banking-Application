package com.turkcell.libraryapp.repository;

import com.turkcell.libraryapp.entity.OgrenciKitap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OgrenciKitapRepository extends JpaRepository<OgrenciKitap, UUID> {

    boolean existsByOgrenci_OgrenciIdAndKutuphaneKitap_KutuphaneKitapIdAndIadeDurumuFalse(
            UUID ogrenciId,
            UUID kutuphaneKitapId
    );
}
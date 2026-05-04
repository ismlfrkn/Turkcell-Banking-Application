package com.turkcell.libraryapp.repository;

import com.turkcell.libraryapp.entity.KutuphaneOgrenci;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KutuphaneOgrenciRepository extends JpaRepository<KutuphaneOgrenci, UUID> {

    boolean existsByKutuphane_KutuphaneIdAndOgrenci_OgrenciId(UUID kutuphaneId, UUID ogrenciId);

    boolean existsByKartNo(String kartNo);
}
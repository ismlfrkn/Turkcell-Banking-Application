package com.turkcell.libraryapplication.repository;

import com.turkcell.libraryapplication.entity.KutuphaneOgrenci;
import com.turkcell.libraryapplication.entity.KutuphaneOgrenciId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KutuphaneOgrenciRepository extends JpaRepository<KutuphaneOgrenci, KutuphaneOgrenciId> {
}

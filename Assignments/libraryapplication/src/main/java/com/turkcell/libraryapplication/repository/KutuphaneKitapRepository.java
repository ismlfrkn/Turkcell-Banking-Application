package com.turkcell.libraryapplication.repository;

import com.turkcell.libraryapplication.entity.KutuphaneKitap;
import com.turkcell.libraryapplication.entity.KutuphaneKitapId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KutuphaneKitapRepository extends JpaRepository<KutuphaneKitap, KutuphaneKitapId> {
}

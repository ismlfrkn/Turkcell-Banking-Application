package com.turkcell.libraryapplication.repository;

import com.turkcell.libraryapplication.entity.OgrenciKitap;
import com.turkcell.libraryapplication.entity.OgrenciKitapId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OgrenciKitapRepository extends JpaRepository<OgrenciKitap, OgrenciKitapId> {
}

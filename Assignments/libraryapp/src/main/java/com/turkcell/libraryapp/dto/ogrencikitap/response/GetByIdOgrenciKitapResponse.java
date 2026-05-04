package com.turkcell.libraryapp.dto.ogrencikitap.response;

import java.time.LocalDate;
import java.util.UUID;

public record GetByIdOgrenciKitapResponse(
        UUID ogrenciKitapId,
        UUID ogrenciId,
        String ogrenciAd,
        String email,
        UUID kutuphaneKitapId,
        UUID kutuphaneId,
        String kutuphaneAd,
        UUID kitapId,
        String kitapAd,
        String kitapTur,
        LocalDate alisTarihi,
        LocalDate sonIadeTarihi,
        LocalDate iadeTarihi,
        boolean iadeDurumu,
        double gecikmeCezasi
) {
}
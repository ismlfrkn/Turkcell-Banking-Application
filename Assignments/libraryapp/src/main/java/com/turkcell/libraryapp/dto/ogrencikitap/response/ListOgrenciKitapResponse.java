package com.turkcell.libraryapp.dto.ogrencikitap.response;

import java.time.LocalDate;
import java.util.UUID;

public record ListOgrenciKitapResponse(
        UUID ogrenciKitapId,
        String ogrenciAd,
        String kutuphaneAd,
        String kitapAd,
        LocalDate alisTarihi,
        LocalDate sonIadeTarihi,
        LocalDate iadeTarihi,
        boolean iadeDurumu,
        double gecikmeCezasi
) {
}
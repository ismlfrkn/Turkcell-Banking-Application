package com.turkcell.libraryapp.dto.ogrencikitap.response;

import java.time.LocalDate;
import java.util.UUID;

public record UpdatedOgrenciKitapResponse(
        UUID ogrenciKitapId,
        UUID ogrenciId,
        UUID kutuphaneKitapId,
        UUID kutuphaneId,
        UUID kitapId,
        LocalDate alisTarihi,
        LocalDate sonIadeTarihi,
        LocalDate iadeTarihi,
        boolean iadeDurumu,
        double gecikmeCezasi
) {
}
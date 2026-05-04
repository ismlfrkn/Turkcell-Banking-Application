package com.turkcell.libraryapp.dto.kutuphanekitap.response;

import java.time.LocalDate;
import java.util.UUID;

public record GetByIdKutuphaneKitapResponse(
        UUID kutuphaneKitapId,
        UUID kutuphaneId,
        String kutuphaneAd,
        UUID kitapId,
        String kitapAd,
        String kitapTur,
        int stokMiktar,
        LocalDate eklemeTarihi
) {
}
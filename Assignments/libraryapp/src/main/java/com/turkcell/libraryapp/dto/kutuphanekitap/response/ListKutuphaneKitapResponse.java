package com.turkcell.libraryapp.dto.kutuphanekitap.response;

import java.time.LocalDate;
import java.util.UUID;

public record ListKutuphaneKitapResponse(
        UUID kutuphaneKitapId,
        String kutuphaneAd,
        String kitapAd,
        int stokMiktar,
        LocalDate eklemeTarihi
) {
}
package com.turkcell.libraryapp.dto.kitap.response;

import java.util.UUID;

public record GetByIdKitapResponse(
        UUID kitapId,
        String kitapAd,
        String kitapTur,
        int sayfaSayi,
        UUID yayineviId,
        String yayineviAd,
        UUID yazarId,
        String yazarAd
) {
}
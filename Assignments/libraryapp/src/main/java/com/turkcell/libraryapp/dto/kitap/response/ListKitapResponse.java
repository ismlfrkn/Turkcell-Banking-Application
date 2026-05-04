package com.turkcell.libraryapp.dto.kitap.response;

import java.util.UUID;

public record ListKitapResponse(
        UUID kitapId,
        String kitapAd,
        String kitapTur,
        int sayfaSayi,
        String yayineviAd,
        String yazarAd
) {
}
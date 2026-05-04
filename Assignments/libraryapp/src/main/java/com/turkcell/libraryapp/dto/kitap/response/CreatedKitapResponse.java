package com.turkcell.libraryapp.dto.kitap.response;

import java.util.UUID;

public record CreatedKitapResponse(
        UUID kitapId,
        String kitapAd,
        String kitapTur,
        int sayfaSayi,
        UUID yayineviId,
        UUID yazarId
) {
}
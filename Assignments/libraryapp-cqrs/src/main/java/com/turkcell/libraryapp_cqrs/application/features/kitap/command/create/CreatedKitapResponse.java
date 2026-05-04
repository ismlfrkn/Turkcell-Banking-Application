package com.turkcell.libraryapp_cqrs.application.features.kitap.command.create;

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
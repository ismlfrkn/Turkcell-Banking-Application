package com.turkcell.libraryapp_cqrs.application.features.kitap.command.create;

import com.turkcell.libraryapp_cqrs.core.mediator.cqrs.Command;

import java.util.UUID;

public record CreateKitapCommand(
        String kitapAd,
        String kitapTur,
        int sayfaSayi,
        UUID yayineviId,
        UUID yazarId
) implements Command<CreatedKitapResponse> {
}
package com.turkcell.libraryapp_cqrs.application.features.yayinevi.command.create;

import java.util.UUID;

public record CreatedYayineviResponse(
        UUID yayineviNo,
        String yayineviAd,
        String telefonNo,
        int ilKodu
) {
}
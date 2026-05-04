package com.turkcell.libraryapp_cqrs.application.features.yazar.command.create;

import java.util.UUID;

public record CreatedYazarResponse(
        UUID yazarNo,
        String yazarAd,
        String ulke,
        UUID yayineviId
) {
}
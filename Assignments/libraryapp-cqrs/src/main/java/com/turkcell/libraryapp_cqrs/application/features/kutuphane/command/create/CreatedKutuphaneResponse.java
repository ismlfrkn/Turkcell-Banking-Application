package com.turkcell.libraryapp_cqrs.application.features.kutuphane.command.create;

import java.time.LocalTime;
import java.util.UUID;

public record CreatedKutuphaneResponse(
        UUID kutuphaneId,
        String kutuphaneAd,
        String telefonNo,
        LocalTime acilisSaati,
        LocalTime kapanisSaati,
        int ilKodu
) {
}
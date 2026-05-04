package com.turkcell.libraryapp.dto.kutuphane.response;

import java.time.LocalTime;
import java.util.UUID;

public record UpdatedKutuphaneResponse(
        UUID kutuphaneId,
        String kutuphaneAd,
        String telefonNo,
        LocalTime acilisSaati,
        LocalTime kapanisSaati,
        int ilKodu
) {
}
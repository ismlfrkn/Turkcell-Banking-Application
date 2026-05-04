package com.turkcell.libraryapp.dto.kutuphane.response;

import java.time.LocalTime;
import java.util.UUID;

public record ListKutuphaneResponse(
        UUID kutuphaneId,
        String kutuphaneAd,
        String telefonNo,
        LocalTime acilisSaati,
        LocalTime kapanisSaati,
        String ilAd
) {
}
package com.turkcell.libraryapp.dto.yazar.response;

import java.util.UUID;

public record GetByIdYazarResponse(
        UUID yazarNo,
        String yazarAd,
        String ulke,
        UUID yayineviId,
        String yayineviAd
) {
}
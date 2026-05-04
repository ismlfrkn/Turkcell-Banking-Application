package com.turkcell.libraryapp.dto.yazar.response;

import java.util.UUID;

public record ListYazarResponse(
        UUID yazarNo,
        String yazarAd,
        String ulke,
        String yayineviAd
) {
}
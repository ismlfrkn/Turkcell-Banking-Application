package com.turkcell.libraryapp.dto.mudur.response;

import java.time.LocalDate;
import java.util.UUID;

public record ListMudurResponse(
        UUID personelNo,
        String personelAd,
        LocalDate gorevBaslangic,
        String kutuphaneAd,
        double mudurMaas,
        String diplomaAlani
) {
}
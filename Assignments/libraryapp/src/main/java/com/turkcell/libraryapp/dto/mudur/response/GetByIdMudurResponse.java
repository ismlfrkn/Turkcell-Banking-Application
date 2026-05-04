package com.turkcell.libraryapp.dto.mudur.response;

import java.time.LocalDate;
import java.util.UUID;

public record GetByIdMudurResponse(
        UUID personelNo,
        String personelAd,
        LocalDate gorevBaslangic,
        UUID kutuphaneId,
        String kutuphaneAd,
        double mudurMaas,
        String diplomaAlani
) {
}
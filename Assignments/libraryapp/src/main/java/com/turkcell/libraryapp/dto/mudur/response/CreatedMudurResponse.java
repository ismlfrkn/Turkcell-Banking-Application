package com.turkcell.libraryapp.dto.mudur.response;

import java.time.LocalDate;
import java.util.UUID;

public record CreatedMudurResponse(
        UUID personelNo,
        String personelAd,
        LocalDate gorevBaslangic,
        UUID kutuphaneId,
        double mudurMaas,
        String diplomaAlani
) {
}
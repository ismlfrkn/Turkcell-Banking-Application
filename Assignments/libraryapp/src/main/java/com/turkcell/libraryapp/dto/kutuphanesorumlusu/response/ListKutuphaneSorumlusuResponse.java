package com.turkcell.libraryapp.dto.kutuphanesorumlusu.response;

import java.time.LocalDate;
import java.util.UUID;

public record ListKutuphaneSorumlusuResponse(
        UUID personelNo,
        String personelAd,
        LocalDate gorevBaslangic,
        String kutuphaneAd,
        double sorumluMaas,
        String uzmanlikAlani,
        String sorumluBolum
) {
}
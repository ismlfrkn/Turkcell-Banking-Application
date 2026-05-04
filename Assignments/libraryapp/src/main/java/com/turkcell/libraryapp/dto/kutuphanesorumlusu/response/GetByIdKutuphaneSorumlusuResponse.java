package com.turkcell.libraryapp.dto.kutuphanesorumlusu.response;

import java.time.LocalDate;
import java.util.UUID;

public record GetByIdKutuphaneSorumlusuResponse(
        UUID personelNo,
        String personelAd,
        LocalDate gorevBaslangic,
        UUID kutuphaneId,
        String kutuphaneAd,
        double sorumluMaas,
        String uzmanlikAlani,
        String sertifikaTuru,
        String sorumluBolum
) {
}
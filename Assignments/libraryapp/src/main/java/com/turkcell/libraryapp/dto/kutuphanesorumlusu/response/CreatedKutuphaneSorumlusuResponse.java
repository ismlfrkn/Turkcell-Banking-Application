package com.turkcell.libraryapp.dto.kutuphanesorumlusu.response;

import java.time.LocalDate;
import java.util.UUID;

public record CreatedKutuphaneSorumlusuResponse(
        UUID personelNo,
        String personelAd,
        LocalDate gorevBaslangic,
        UUID kutuphaneId,
        double sorumluMaas,
        String uzmanlikAlani,
        String sertifikaTuru,
        String sorumluBolum
) {
}
package com.turkcell.libraryapp.dto.hademe.response;

import java.time.LocalDate;
import java.util.UUID;

public record GetByIdHademeResponse(
        UUID personelNo,
        String personelAd,
        LocalDate gorevBaslangic,
        UUID kutuphaneId,
        String kutuphaneAd,
        double hademeMaas,
        String vardiyaTuru,
        String temizlikBolgesi
) {
}
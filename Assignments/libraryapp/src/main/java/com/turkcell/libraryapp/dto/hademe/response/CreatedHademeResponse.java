package com.turkcell.libraryapp.dto.hademe.response;

import java.time.LocalDate;
import java.util.UUID;

public record CreatedHademeResponse(
        UUID personelNo,
        String personelAd,
        LocalDate gorevBaslangic,
        UUID kutuphaneId,
        double hademeMaas,
        String vardiyaTuru,
        String temizlikBolgesi
) {
}
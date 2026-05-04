package com.turkcell.libraryapp.dto.hademe.response;

import java.time.LocalDate;
import java.util.UUID;

public record ListHademeResponse(
        UUID personelNo,
        String personelAd,
        LocalDate gorevBaslangic,
        String kutuphaneAd,
        double hademeMaas,
        String vardiyaTuru,
        String temizlikBolgesi
) {
}
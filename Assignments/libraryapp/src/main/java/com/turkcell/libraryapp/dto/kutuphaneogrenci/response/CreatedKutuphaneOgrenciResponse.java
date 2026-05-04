package com.turkcell.libraryapp.dto.kutuphaneogrenci.response;

import java.time.LocalDate;
import java.util.UUID;

public record CreatedKutuphaneOgrenciResponse(
        UUID kutuphaneOgrenciId,
        UUID kutuphaneId,
        UUID ogrenciId,
        LocalDate kayitTarihi,
        String kartNo,
        boolean aktifMi
) {
}
package com.turkcell.libraryapp.dto.kutuphanekitap.response;

import java.time.LocalDate;
import java.util.UUID;

public record CreatedKutuphaneKitapResponse(
        UUID kutuphaneKitapId,
        UUID kutuphaneId,
        UUID kitapId,
        int stokMiktar,
        LocalDate eklemeTarihi
) {
}
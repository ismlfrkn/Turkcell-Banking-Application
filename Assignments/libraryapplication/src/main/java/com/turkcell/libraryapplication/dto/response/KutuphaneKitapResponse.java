package com.turkcell.libraryapplication.dto.response;

import java.time.LocalDate;
import java.util.UUID;

public class KutuphaneKitapResponse {

    private UUID kutuphaneId;
    private UUID kitapId;
    private int stokMiktar;
    private LocalDate eklemeTarihi;

    public KutuphaneKitapResponse() {}

    public UUID getKutuphaneId() { return kutuphaneId; }
    public void setKutuphaneId(UUID kutuphaneId) { this.kutuphaneId = kutuphaneId; }
    public UUID getKitapId() { return kitapId; }
    public void setKitapId(UUID kitapId) { this.kitapId = kitapId; }
    public int getStokMiktar() { return stokMiktar; }
    public void setStokMiktar(int stokMiktar) { this.stokMiktar = stokMiktar; }
    public LocalDate getEklemeTarihi() { return eklemeTarihi; }
    public void setEklemeTarihi(LocalDate eklemeTarihi) { this.eklemeTarihi = eklemeTarihi; }
}

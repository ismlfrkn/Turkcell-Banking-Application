package com.turkcell.libraryapplication.dto.request;

import java.time.LocalDate;

public class UpdateKutuphaneKitapRequest {

    private int stokMiktar;
    private LocalDate eklemeTarihi;

    public int getStokMiktar() { return stokMiktar; }
    public void setStokMiktar(int stokMiktar) { this.stokMiktar = stokMiktar; }
    public LocalDate getEklemeTarihi() { return eklemeTarihi; }
    public void setEklemeTarihi(LocalDate eklemeTarihi) { this.eklemeTarihi = eklemeTarihi; }
}

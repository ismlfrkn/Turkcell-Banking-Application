package com.turkcell.libraryapplication.dto.request;

import java.time.LocalDate;

public class UpdateOgrenciKitapRequest {

    private LocalDate alisTarihi;
    private LocalDate iadeTarihi;
    private boolean iadeDurumu;

    public LocalDate getAlisTarihi() { return alisTarihi; }
    public void setAlisTarihi(LocalDate alisTarihi) { this.alisTarihi = alisTarihi; }
    public LocalDate getIadeTarihi() { return iadeTarihi; }
    public void setIadeTarihi(LocalDate iadeTarihi) { this.iadeTarihi = iadeTarihi; }
    public boolean isIadeDurumu() { return iadeDurumu; }
    public void setIadeDurumu(boolean iadeDurumu) { this.iadeDurumu = iadeDurumu; }
}

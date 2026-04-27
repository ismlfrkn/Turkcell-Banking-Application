package com.turkcell.libraryapplication.dto.request;

import java.time.LocalDate;
import java.util.UUID;

public class CreateOgrenciKitapRequest {

    private UUID ogrenciId;
    private UUID kitapId;
    private LocalDate alisTarihi;
    private LocalDate iadeTarihi;
    private boolean iadeDurumu;

    public UUID getOgrenciId() { return ogrenciId; }
    public void setOgrenciId(UUID ogrenciId) { this.ogrenciId = ogrenciId; }
    public UUID getKitapId() { return kitapId; }
    public void setKitapId(UUID kitapId) { this.kitapId = kitapId; }
    public LocalDate getAlisTarihi() { return alisTarihi; }
    public void setAlisTarihi(LocalDate alisTarihi) { this.alisTarihi = alisTarihi; }
    public LocalDate getIadeTarihi() { return iadeTarihi; }
    public void setIadeTarihi(LocalDate iadeTarihi) { this.iadeTarihi = iadeTarihi; }
    public boolean isIadeDurumu() { return iadeDurumu; }
    public void setIadeDurumu(boolean iadeDurumu) { this.iadeDurumu = iadeDurumu; }
}

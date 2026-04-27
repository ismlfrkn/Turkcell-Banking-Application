package com.turkcell.libraryapplication.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class OgrenciKitapId implements Serializable {

    private UUID ogrenci;
    private UUID kitap;

    public OgrenciKitapId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OgrenciKitapId)) return false;
        OgrenciKitapId that = (OgrenciKitapId) o;
        return Objects.equals(ogrenci, that.ogrenci) && Objects.equals(kitap, that.kitap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ogrenci, kitap);
    }

    public UUID getOgrenci() {
        return ogrenci;
    }

    public void setOgrenci(UUID ogrenci) {
        this.ogrenci = ogrenci;
    }

    public UUID getKitap() {
        return kitap;
    }

    public void setKitap(UUID kitap) {
        this.kitap = kitap;
    }

    
}
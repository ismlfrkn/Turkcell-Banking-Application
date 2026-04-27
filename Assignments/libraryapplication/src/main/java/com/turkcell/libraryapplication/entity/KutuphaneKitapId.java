package com.turkcell.libraryapplication.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class KutuphaneKitapId implements Serializable {

    private UUID kutuphane;
    private UUID kitap;

    public KutuphaneKitapId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KutuphaneKitapId)) return false;
        KutuphaneKitapId that = (KutuphaneKitapId) o;
        return Objects.equals(kutuphane, that.kutuphane) && Objects.equals(kitap, that.kitap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kutuphane, kitap);
    }

    public UUID getKutuphane() {
        return kutuphane;
    }

    public void setKutuphane(UUID kutuphane) {
        this.kutuphane = kutuphane;
    }

    public UUID getKitap() {
        return kitap;
    }

    public void setKitap(UUID kitap) {
        this.kitap = kitap;
    }

    
}
package com.turkcell.libraryapplication.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class KutuphaneOgrenciId implements Serializable {

    private UUID ogrenci;
    private UUID kutuphane;

    public KutuphaneOgrenciId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KutuphaneOgrenciId)) return false;
        KutuphaneOgrenciId that = (KutuphaneOgrenciId) o;
        return Objects.equals(ogrenci, that.ogrenci) && Objects.equals(kutuphane, that.kutuphane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ogrenci, kutuphane);
    }

    public UUID getOgrenci() {
        return ogrenci;
    }

    public void setOgrenci(UUID ogrenci) {
        this.ogrenci = ogrenci;
    }

    public UUID getKutuphane() {
        return kutuphane;
    }

    public void setKutuphane(UUID kutuphane) {
        this.kutuphane = kutuphane;
    }
}
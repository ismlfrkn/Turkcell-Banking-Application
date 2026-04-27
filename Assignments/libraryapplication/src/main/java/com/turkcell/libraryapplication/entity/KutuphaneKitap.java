package com.turkcell.libraryapplication.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "kutuphane_kitap")
@IdClass(KutuphaneKitapId.class)
public class KutuphaneKitap {

    @Id
    @ManyToOne
    @JoinColumn(name = "kutuphane_id")
    private Kutuphane kutuphane;

    @Id
    @ManyToOne
    @JoinColumn(name = "kitap_id")
    private Kitap kitap;

    @Column(name = "stok_miktar")
    private int stokMiktar;

    @Column(name = "ekleme_tarihi")
    private LocalDate eklemeTarihi;

    public Kutuphane getKutuphane() {
        return kutuphane;
    }

    public void setKutuphane(Kutuphane kutuphane) {
        this.kutuphane = kutuphane;
    }

    public Kitap getKitap() {
        return kitap;
    }

    public void setKitap(Kitap kitap) {
        this.kitap = kitap;
    }

    public int getStokMiktar() {
        return stokMiktar;
    }

    public void setStokMiktar(int stokMiktar) {
        this.stokMiktar = stokMiktar;
    }

    public LocalDate getEklemeTarihi() {
        return eklemeTarihi;
    }

    public void setEklemeTarihi(LocalDate eklemeTarihi) {
        this.eklemeTarihi = eklemeTarihi;
    }

    
}
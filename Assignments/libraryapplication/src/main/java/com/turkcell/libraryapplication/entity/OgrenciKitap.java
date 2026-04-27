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
@Table(name = "ogrenci_kitap")
@IdClass(OgrenciKitapId.class)
public class OgrenciKitap {

    @Id
    @ManyToOne
    @JoinColumn(name = "ogrenci_id")
    private Ogrenci ogrenci;

    @Id
    @ManyToOne
    @JoinColumn(name = "kitap_id")
    private Kitap kitap;

    @Column(name = "alis_tarihi")
    private LocalDate alisTarihi;

    @Column(name = "iade_tarihi")
    private LocalDate iadeTarihi;

    @Column(name = "iade_durumu")
    private boolean iadeDurumu;

    public Ogrenci getOgrenci() {
        return ogrenci;
    }

    public void setOgrenci(Ogrenci ogrenci) {
        this.ogrenci = ogrenci;
    }

    public Kitap getKitap() {
        return kitap;
    }

    public void setKitap(Kitap kitap) {
        this.kitap = kitap;
    }

    public LocalDate getAlisTarihi() {
        return alisTarihi;
    }

    public void setAlisTarihi(LocalDate alisTarihi) {
        this.alisTarihi = alisTarihi;
    }

    public LocalDate getIadeTarihi() {
        return iadeTarihi;
    }

    public void setIadeTarihi(LocalDate iadeTarihi) {
        this.iadeTarihi = iadeTarihi;
    }

    public boolean isIadeDurumu() {
        return iadeDurumu;
    }

    public void setIadeDurumu(boolean iadeDurumu) {
        this.iadeDurumu = iadeDurumu;
    }

    
}
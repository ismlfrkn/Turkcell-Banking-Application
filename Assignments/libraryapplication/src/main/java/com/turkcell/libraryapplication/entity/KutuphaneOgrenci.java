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
@Table(name = "kutuphane_ogrenci")
@IdClass(KutuphaneOgrenciId.class)
public class KutuphaneOgrenci {

    @Id
    @ManyToOne
    @JoinColumn(name = "ogrenci_id")
    private Ogrenci ogrenci;

    @Id
    @ManyToOne
    @JoinColumn(name = "kutuphane_id")
    private Kutuphane kutuphane;

    @Column(name = "kayit_tarihi")
    private LocalDate kayitTarihi;

    @Column(name = "kart_no", length = 50)
    private String kartNo;

    @Column(name = "aktif_mi")
    private boolean aktifMi;

    public Ogrenci getOgrenci() {
        return ogrenci;
    }

    public void setOgrenci(Ogrenci ogrenci) {
        this.ogrenci = ogrenci;
    }

    public Kutuphane getKutuphane() {
        return kutuphane;
    }

    public void setKutuphane(Kutuphane kutuphane) {
        this.kutuphane = kutuphane;
    }

    public LocalDate getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(LocalDate kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

    public String getKartNo() {
        return kartNo;
    }

    public void setKartNo(String kartNo) {
        this.kartNo = kartNo;
    }

    public boolean isAktifMi() {
        return aktifMi;
    }

    public void setAktifMi(boolean aktifMi) {
        this.aktifMi = aktifMi;
    }

    
}

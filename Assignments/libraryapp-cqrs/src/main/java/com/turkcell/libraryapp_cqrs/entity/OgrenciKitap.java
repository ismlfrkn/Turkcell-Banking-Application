package com.turkcell.libraryapp_cqrs.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;

@Entity
@Table(name = "ogrenci_kitap")
public class OgrenciKitap {

    @Id
    @UuidGenerator
    @Column(name = "ogrenci_kitap_id", nullable = false, updatable = false)
    private UUID ogrenciKitapId;

    @ManyToOne
    @JoinColumn(name = "ogrenci_id", nullable = false)
    private Ogrenci ogrenci;

    @ManyToOne
    @JoinColumn(name = "kutuphane_kitap_id", nullable = false)
    private KutuphaneKitap kutuphaneKitap;

    @CreationTimestamp
    @Column(name = "alis_tarihi", nullable = false, updatable = false)
    private LocalDate alisTarihi;

    @Column(name = "son_iade_tarihi", nullable = false)
    private LocalDate sonIadeTarihi;

    @Column(name = "iade_tarihi")
    private LocalDate iadeTarihi;

    @Column(name = "iade_durumu", nullable = false)
    private boolean iadeDurumu = false;

    @Column(name = "gecikme_cezasi", nullable = false)
    private double gecikmeCezasi = 0;

    @PrePersist
    public void prePersist() {
        this.sonIadeTarihi = LocalDate.now().plusDays(14);
    }

    public UUID getOgrenciKitapId() {
        return ogrenciKitapId;
    }

    public void setOgrenciKitapId(UUID ogrenciKitapId) {
        this.ogrenciKitapId = ogrenciKitapId;
    }

    public Ogrenci getOgrenci() {
        return ogrenci;
    }

    public void setOgrenci(Ogrenci ogrenci) {
        this.ogrenci = ogrenci;
    }

    public KutuphaneKitap getKutuphaneKitap() {
        return kutuphaneKitap;
    }

    public void setKutuphaneKitap(KutuphaneKitap kutuphaneKitap) {
        this.kutuphaneKitap = kutuphaneKitap;
    }

    public LocalDate getAlisTarihi() {
        return alisTarihi;
    }

    public LocalDate getSonIadeTarihi() {
        return sonIadeTarihi;
    }

    public void setSonIadeTarihi(LocalDate sonIadeTarihi) {
        this.sonIadeTarihi = sonIadeTarihi;
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

    public double getGecikmeCezasi() {
        return gecikmeCezasi;
    }

    public void setGecikmeCezasi(double gecikmeCezasi) {
        this.gecikmeCezasi = gecikmeCezasi;
    }
}
package com.turkcell.libraryapp.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(
    name = "kutuphane_kitap",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"kutuphane_id", "kitap_id"})
    }
)
public class KutuphaneKitap {

    @Id
    @UuidGenerator
    @Column(name = "kutuphane_kitap_id", nullable = false, updatable = false)
    private UUID kutuphaneKitapId;

    @ManyToOne
    @JoinColumn(name = "kutuphane_id", nullable = false)
    private Kutuphane kutuphane;

    @ManyToOne
    @JoinColumn(name = "kitap_id", nullable = false)
    private Kitap kitap;

    @Min(value = 0, message = "Stok miktarı negatif olamaz")
    @Column(name = "stok_miktar", nullable = false)
    private int stokMiktar;

    @CreationTimestamp
    @Column(name = "ekleme_tarihi", nullable = false, updatable = false)
    private LocalDate eklemeTarihi;

    public UUID getKutuphaneKitapId() {
        return kutuphaneKitapId;
    }

    public void setKutuphaneKitapId(UUID kutuphaneKitapId) {
        this.kutuphaneKitapId = kutuphaneKitapId;
    }

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
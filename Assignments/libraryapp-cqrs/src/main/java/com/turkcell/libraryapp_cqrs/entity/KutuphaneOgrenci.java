package com.turkcell.libraryapp_cqrs.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(
    name = "kutuphane_ogrenci",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"kutuphane_id", "ogrenci_id"})
    }
)
public class KutuphaneOgrenci {

    @Id
    @UuidGenerator
    @Column(name = "kutuphane_ogrenci_id", nullable = false, updatable = false)
    private UUID kutuphaneOgrenciId;

    @ManyToOne
    @JoinColumn(name = "kutuphane_id", nullable = false)
    private Kutuphane kutuphane;

    @ManyToOne
    @JoinColumn(name = "ogrenci_id", nullable = false)
    private Ogrenci ogrenci;

    @CreationTimestamp
    @Column(name = "kayit_tarihi", nullable = false, updatable = false)
    private LocalDate kayitTarihi;

    @NotBlank(message = "Kart numarası boş bırakılamaz.")
    @Column(name = "kart_no", nullable = false, unique = true, length = 50)
    private String kartNo;

    @Column(name = "aktif_mi", nullable = false)
    private boolean aktifMi = true;

   

    public UUID getKutuphaneOgrenciId() {
        return kutuphaneOgrenciId;
    }

    public void setKutuphaneOgrenciId(UUID kutuphaneOgrenciId) {
        this.kutuphaneOgrenciId = kutuphaneOgrenciId;
    }

    public Kutuphane getKutuphane() {
        return kutuphane;
    }

    public void setKutuphane(Kutuphane kutuphane) {
        this.kutuphane = kutuphane;
    }

    public Ogrenci getOgrenci() {
        return ogrenci;
    }

    public void setOgrenci(Ogrenci ogrenci) {
        this.ogrenci = ogrenci;
    }

    public LocalDate getKayitTarihi() {
        return kayitTarihi;
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
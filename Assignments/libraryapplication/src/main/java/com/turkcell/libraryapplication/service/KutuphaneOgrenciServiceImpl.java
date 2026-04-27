package com.turkcell.libraryapplication.service;

import com.turkcell.libraryapplication.dto.request.CreateKutuphaneOgrenciRequest;
import com.turkcell.libraryapplication.dto.request.UpdateKutuphaneOgrenciRequest;
import com.turkcell.libraryapplication.dto.response.KutuphaneOgrenciResponse;
import com.turkcell.libraryapplication.entity.Kutuphane;
import com.turkcell.libraryapplication.entity.KutuphaneOgrenci;
import com.turkcell.libraryapplication.entity.KutuphaneOgrenciId;
import com.turkcell.libraryapplication.entity.Ogrenci;
import com.turkcell.libraryapplication.repository.KutuphaneOgrenciRepository;
import com.turkcell.libraryapplication.repository.KutuphaneRepository;
import com.turkcell.libraryapplication.repository.OgrenciRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KutuphaneOgrenciServiceImpl {

    private final KutuphaneOgrenciRepository kutuphaneOgrenciRepository;
    private final KutuphaneRepository kutuphaneRepository;
    private final OgrenciRepository ogrenciRepository;

    public KutuphaneOgrenciServiceImpl(KutuphaneOgrenciRepository kutuphaneOgrenciRepository,
                                        KutuphaneRepository kutuphaneRepository,
                                        OgrenciRepository ogrenciRepository) {
        this.kutuphaneOgrenciRepository = kutuphaneOgrenciRepository;
        this.kutuphaneRepository = kutuphaneRepository;
        this.ogrenciRepository = ogrenciRepository;
    }

    public List<KutuphaneOgrenciResponse> getAll() {
        return kutuphaneOgrenciRepository.findAll()
                .stream()
                .map(ko -> {
                    KutuphaneOgrenciResponse response = new KutuphaneOgrenciResponse();
                    response.setOgrenciId(ko.getOgrenci().getOgrenciID());
                    response.setKutuphaneId(ko.getKutuphane().getKutuphaneID());
                    response.setKayitTarihi(ko.getKayitTarihi());
                    response.setKartNo(ko.getKartNo());
                    response.setAktifMi(ko.isAktifMi());
                    return response;
                })
                .toList();
    }

    public KutuphaneOgrenciResponse getById(UUID ogrenciId, UUID kutuphaneId) {
        KutuphaneOgrenciId id = new KutuphaneOgrenciId();
        id.setOgrenci(ogrenciId);
        id.setKutuphane(kutuphaneId);

        KutuphaneOgrenci ko = kutuphaneOgrenciRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KutuphaneOgrenci bulunamadı"));

        KutuphaneOgrenciResponse response = new KutuphaneOgrenciResponse();
        response.setOgrenciId(ko.getOgrenci().getOgrenciID());
        response.setKutuphaneId(ko.getKutuphane().getKutuphaneID());
        response.setKayitTarihi(ko.getKayitTarihi());
        response.setKartNo(ko.getKartNo());
        response.setAktifMi(ko.isAktifMi());
        return response;
    }

    public KutuphaneOgrenciResponse add(CreateKutuphaneOgrenciRequest request) {
        Ogrenci ogrenci = ogrenciRepository.findById(request.getOgrenciId())
                .orElseThrow(() -> new RuntimeException("Ogrenci bulunamadı"));
        Kutuphane kutuphane = kutuphaneRepository.findById(request.getKutuphaneId())
                .orElseThrow(() -> new RuntimeException("Kutuphane bulunamadı"));

        KutuphaneOgrenci ko = new KutuphaneOgrenci();
        ko.setOgrenci(ogrenci);
        ko.setKutuphane(kutuphane);
        ko.setKayitTarihi(request.getKayitTarihi());
        ko.setKartNo(request.getKartNo());
        ko.setAktifMi(request.isAktifMi());
        kutuphaneOgrenciRepository.save(ko);

        KutuphaneOgrenciResponse response = new KutuphaneOgrenciResponse();
        response.setOgrenciId(ko.getOgrenci().getOgrenciID());
        response.setKutuphaneId(ko.getKutuphane().getKutuphaneID());
        response.setKayitTarihi(ko.getKayitTarihi());
        response.setKartNo(ko.getKartNo());
        response.setAktifMi(ko.isAktifMi());
        return response;
    }

    public KutuphaneOgrenciResponse update(UUID ogrenciId, UUID kutuphaneId,
                                            UpdateKutuphaneOgrenciRequest request) {
        KutuphaneOgrenciId id = new KutuphaneOgrenciId();
        id.setOgrenci(ogrenciId);
        id.setKutuphane(kutuphaneId);

        KutuphaneOgrenci ko = kutuphaneOgrenciRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KutuphaneOgrenci bulunamadı"));

        ko.setKayitTarihi(request.getKayitTarihi());
        ko.setKartNo(request.getKartNo());
        ko.setAktifMi(request.isAktifMi());
        kutuphaneOgrenciRepository.save(ko);

        KutuphaneOgrenciResponse response = new KutuphaneOgrenciResponse();
        response.setOgrenciId(ko.getOgrenci().getOgrenciID());
        response.setKutuphaneId(ko.getKutuphane().getKutuphaneID());
        response.setKayitTarihi(ko.getKayitTarihi());
        response.setKartNo(ko.getKartNo());
        response.setAktifMi(ko.isAktifMi());
        return response;
    }

    public void delete(UUID ogrenciId, UUID kutuphaneId) {
        KutuphaneOgrenciId id = new KutuphaneOgrenciId();
        id.setOgrenci(ogrenciId);
        id.setKutuphane(kutuphaneId);

        KutuphaneOgrenci ko = kutuphaneOgrenciRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KutuphaneOgrenci bulunamadı"));
        kutuphaneOgrenciRepository.delete(ko);
    }
}

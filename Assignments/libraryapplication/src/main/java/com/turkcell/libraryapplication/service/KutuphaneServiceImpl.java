package com.turkcell.libraryapplication.service;

import com.turkcell.libraryapplication.dto.request.CreateKutuphaneRequest;
import com.turkcell.libraryapplication.dto.request.UpdateKutuphaneRequest;
import com.turkcell.libraryapplication.dto.response.KutuphaneResponse;
import com.turkcell.libraryapplication.entity.Adres;
import com.turkcell.libraryapplication.entity.Kutuphane;
import com.turkcell.libraryapplication.repository.AdresRepository;
import com.turkcell.libraryapplication.repository.KutuphaneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KutuphaneServiceImpl {

    private final KutuphaneRepository kutuphaneRepository;
    private final AdresRepository adresRepository;

    public KutuphaneServiceImpl(KutuphaneRepository kutuphaneRepository, AdresRepository adresRepository) {
        this.kutuphaneRepository = kutuphaneRepository;
        this.adresRepository = adresRepository;
    }

    public List<KutuphaneResponse> getAll() {
        return kutuphaneRepository.findAll()
                .stream()
                .map(k -> {
                    KutuphaneResponse response = new KutuphaneResponse();
                    response.setKutuphaneID(k.getKutuphaneID());
                    response.setKutuphaneAd(k.getKutuphaneAd());
                    response.setTelefonNo(k.getTelefonNo());
                    response.setAcilisSaati(k.getAcilisSaati());
                    response.setKapanisSaati(k.getKapanisSaati());
                    response.setIlKodu(k.getAdres().getIlKodu());
                    return response;
                })
                .toList();
    }

    public KutuphaneResponse getById(UUID id) {
        Kutuphane k = kutuphaneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kutuphane bulunamadı: " + id));

        KutuphaneResponse response = new KutuphaneResponse();
        response.setKutuphaneID(k.getKutuphaneID());
        response.setKutuphaneAd(k.getKutuphaneAd());
        response.setTelefonNo(k.getTelefonNo());
        response.setAcilisSaati(k.getAcilisSaati());
        response.setKapanisSaati(k.getKapanisSaati());
        response.setIlKodu(k.getAdres().getIlKodu());
        return response;
    }

    public KutuphaneResponse add(CreateKutuphaneRequest request) {
        Adres adres = adresRepository.findById(request.getIlKodu())
                .orElseThrow(() -> new RuntimeException("Adres bulunamadı"));

        Kutuphane k = new Kutuphane();
        k.setKutuphaneAd(request.getKutuphaneAd());
        k.setTelefonNo(request.getTelefonNo());
        k.setAcilisSaati(request.getAcilisSaati());
        k.setKapanisSaati(request.getKapanisSaati());
        k.setAdres(adres);
        kutuphaneRepository.save(k);

        KutuphaneResponse response = new KutuphaneResponse();
        response.setKutuphaneID(k.getKutuphaneID());
        response.setKutuphaneAd(k.getKutuphaneAd());
        response.setTelefonNo(k.getTelefonNo());
        response.setAcilisSaati(k.getAcilisSaati());
        response.setKapanisSaati(k.getKapanisSaati());
        response.setIlKodu(k.getAdres().getIlKodu());
        return response;
    }

    public KutuphaneResponse update(UUID id, UpdateKutuphaneRequest request) {
        Kutuphane k = kutuphaneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kutuphane bulunamadı: " + id));
        Adres adres = adresRepository.findById(request.getIlKodu())
                .orElseThrow(() -> new RuntimeException("Adres bulunamadı"));

        k.setKutuphaneAd(request.getKutuphaneAd());
        k.setTelefonNo(request.getTelefonNo());
        k.setAcilisSaati(request.getAcilisSaati());
        k.setKapanisSaati(request.getKapanisSaati());
        k.setAdres(adres);
        kutuphaneRepository.save(k);

        KutuphaneResponse response = new KutuphaneResponse();
        response.setKutuphaneID(k.getKutuphaneID());
        response.setKutuphaneAd(k.getKutuphaneAd());
        response.setTelefonNo(k.getTelefonNo());
        response.setAcilisSaati(k.getAcilisSaati());
        response.setKapanisSaati(k.getKapanisSaati());
        response.setIlKodu(k.getAdres().getIlKodu());
        return response;
    }

    public void delete(UUID id) {
        Kutuphane k = kutuphaneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kutuphane bulunamadı: " + id));
        kutuphaneRepository.delete(k);
    }
}

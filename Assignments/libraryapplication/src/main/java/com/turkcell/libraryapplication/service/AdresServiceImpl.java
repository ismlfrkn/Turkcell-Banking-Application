package com.turkcell.libraryapplication.service;

import com.turkcell.libraryapplication.dto.request.CreateAdresRequest;
import com.turkcell.libraryapplication.dto.request.UpdateAdresRequest;
import com.turkcell.libraryapplication.dto.response.AdresResponse;
import com.turkcell.libraryapplication.entity.Adres;
import com.turkcell.libraryapplication.repository.AdresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresServiceImpl {

    private final AdresRepository adresRepository;

    public AdresServiceImpl(AdresRepository adresRepository) {
        this.adresRepository = adresRepository;
    }

    public List<AdresResponse> getAll() {
        return adresRepository.findAll()
                .stream()
                .map(adres -> {
                    AdresResponse response = new AdresResponse();
                    response.setIlKodu(adres.getIlKodu());
                    response.setIlAdi(adres.getIlAdi());
                    response.setIlceAd(adres.getIlceAd());
                    response.setBolge(adres.getBolge());
                    return response;
                })
                .toList();
    }

    public AdresResponse getById(int ilKodu) {
        Adres adres = adresRepository.findById(ilKodu)
                .orElseThrow(() -> new RuntimeException("Adres bulunamadı: " + ilKodu));

        AdresResponse response = new AdresResponse();
        response.setIlKodu(adres.getIlKodu());
        response.setIlAdi(adres.getIlAdi());
        response.setIlceAd(adres.getIlceAd());
        response.setBolge(adres.getBolge());

        return response;
    }

    public AdresResponse add(CreateAdresRequest request) {
        Adres adres = new Adres();
        adres.setIlKodu(request.getIlKodu());
        adres.setIlAdi(request.getIlAdi());
        adres.setIlceAd(request.getIlceAd());
        adres.setBolge(request.getBolge());
        adresRepository.save(adres);

        AdresResponse response = new AdresResponse();
        response.setIlKodu(adres.getIlKodu());
        response.setIlAdi(adres.getIlAdi());
        response.setIlceAd(adres.getIlceAd());
        response.setBolge(adres.getBolge());

        return response;
    }

    public AdresResponse update(int ilKodu, UpdateAdresRequest request) {
        Adres adres = adresRepository.findById(ilKodu)
                .orElseThrow(() -> new RuntimeException("Adres bulunamadı: " + ilKodu));

        adres.setIlAdi(request.getIlAdi());
        adres.setIlceAd(request.getIlceAd());
        adres.setBolge(request.getBolge());
        adresRepository.save(adres);

        AdresResponse response = new AdresResponse();
        response.setIlKodu(adres.getIlKodu());
        response.setIlAdi(adres.getIlAdi());
        response.setIlceAd(adres.getIlceAd());
        response.setBolge(adres.getBolge());

        return response;
    }

    public void delete(int ilKodu) {
        Adres adres = adresRepository.findById(ilKodu)
                .orElseThrow(() -> new RuntimeException("Adres bulunamadı: " + ilKodu));
        adresRepository.delete(adres);
    }
}
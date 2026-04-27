package com.turkcell.libraryapplication.service;

import com.turkcell.libraryapplication.dto.request.CreateYayineviRequest;
import com.turkcell.libraryapplication.dto.request.UpdateYayineviRequest;
import com.turkcell.libraryapplication.dto.response.YayineviResponse;
import com.turkcell.libraryapplication.entity.Adres;
import com.turkcell.libraryapplication.entity.Yayinevi;
import com.turkcell.libraryapplication.repository.AdresRepository;
import com.turkcell.libraryapplication.repository.YayineviRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class YayineviServiceImpl {

    private final YayineviRepository yayineviRepository;
    private final AdresRepository adresRepository;

    public YayineviServiceImpl(YayineviRepository yayineviRepository, AdresRepository adresRepository) {
        this.yayineviRepository = yayineviRepository;
        this.adresRepository = adresRepository;
    }

    public List<YayineviResponse> getAll() {
        return yayineviRepository.findAll()
                .stream()
                .map(y -> {
                    YayineviResponse response = new YayineviResponse();
                    response.setYayineviNo(y.getYayineviNo());
                    response.setYayineviAd(y.getYayineviAd());
                    response.setTelefonNo(y.getTelefonNo());
                    response.setIlKodu(y.getAdres().getIlKodu());
                    return response;
                })
                .toList();
    }

    public YayineviResponse getById(UUID id) {
        Yayinevi y = yayineviRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Yayinevi bulunamadı: " + id));

        YayineviResponse response = new YayineviResponse();
        response.setYayineviNo(y.getYayineviNo());
        response.setYayineviAd(y.getYayineviAd());
        response.setTelefonNo(y.getTelefonNo());
        response.setIlKodu(y.getAdres().getIlKodu());
        return response;
    }

    public YayineviResponse add(CreateYayineviRequest request) {
        Adres adres = adresRepository.findById(request.getIlKodu())
                .orElseThrow(() -> new RuntimeException("Adres bulunamadı"));

        Yayinevi y = new Yayinevi();
        y.setYayineviAd(request.getYayineviAd());
        y.setTelefonNo(request.getTelefonNo());
        y.setAdres(adres);
        yayineviRepository.save(y);

        YayineviResponse response = new YayineviResponse();
        response.setYayineviNo(y.getYayineviNo());
        response.setYayineviAd(y.getYayineviAd());
        response.setTelefonNo(y.getTelefonNo());
        response.setIlKodu(y.getAdres().getIlKodu());
        return response;
    }

    public YayineviResponse update(UUID id, UpdateYayineviRequest request) {
        Yayinevi y = yayineviRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Yayinevi bulunamadı: " + id));
        Adres adres = adresRepository.findById(request.getIlKodu())
                .orElseThrow(() -> new RuntimeException("Adres bulunamadı"));

        y.setYayineviAd(request.getYayineviAd());
        y.setTelefonNo(request.getTelefonNo());
        y.setAdres(adres);
        yayineviRepository.save(y);

        YayineviResponse response = new YayineviResponse();
        response.setYayineviNo(y.getYayineviNo());
        response.setYayineviAd(y.getYayineviAd());
        response.setTelefonNo(y.getTelefonNo());
        response.setIlKodu(y.getAdres().getIlKodu());
        return response;
    }

    public void delete(UUID id) {
        Yayinevi y = yayineviRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Yayinevi bulunamadı: " + id));
        yayineviRepository.delete(y);
    }
}

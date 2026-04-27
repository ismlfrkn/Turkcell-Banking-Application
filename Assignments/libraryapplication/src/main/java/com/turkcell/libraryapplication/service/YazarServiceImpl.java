package com.turkcell.libraryapplication.service;

import com.turkcell.libraryapplication.dto.request.CreateYazarRequest;
import com.turkcell.libraryapplication.dto.request.UpdateYazarRequest;
import com.turkcell.libraryapplication.dto.response.YazarResponse;
import com.turkcell.libraryapplication.entity.Yayinevi;
import com.turkcell.libraryapplication.entity.Yazar;
import com.turkcell.libraryapplication.repository.YayineviRepository;
import com.turkcell.libraryapplication.repository.YazarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class YazarServiceImpl {

    private final YazarRepository yazarRepository;
    private final YayineviRepository yayineviRepository;

    public YazarServiceImpl(YazarRepository yazarRepository, YayineviRepository yayineviRepository) {
        this.yazarRepository = yazarRepository;
        this.yayineviRepository = yayineviRepository;
    }

    public List<YazarResponse> getAll() {
        return yazarRepository.findAll()
                .stream()
                .map(y -> {
                    YazarResponse response = new YazarResponse();
                    response.setYazarNo(y.getYazarNo());
                    response.setYazarAd(y.getYazarAd());
                    response.setUlke(y.getUlke());
                    response.setYayineviNo(y.getYayinevi().getYayineviNo());
                    return response;
                })
                .toList();
    }

    public YazarResponse getById(UUID id) {
        Yazar y = yazarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Yazar bulunamadı: " + id));

        YazarResponse response = new YazarResponse();
        response.setYazarNo(y.getYazarNo());
        response.setYazarAd(y.getYazarAd());
        response.setUlke(y.getUlke());
        response.setYayineviNo(y.getYayinevi().getYayineviNo());
        return response;
    }

    public YazarResponse add(CreateYazarRequest request) {
        Yayinevi yayinevi = yayineviRepository.findById(request.getYayineviNo())
                .orElseThrow(() -> new RuntimeException("Yayinevi bulunamadı"));

        Yazar y = new Yazar();
        y.setYazarAd(request.getYazarAd());
        y.setUlke(request.getUlke());
        y.setYayinevi(yayinevi);
        yazarRepository.save(y);

        YazarResponse response = new YazarResponse();
        response.setYazarNo(y.getYazarNo());
        response.setYazarAd(y.getYazarAd());
        response.setUlke(y.getUlke());
        response.setYayineviNo(y.getYayinevi().getYayineviNo());
        return response;
    }

    public YazarResponse update(UUID id, UpdateYazarRequest request) {
        Yazar y = yazarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Yazar bulunamadı: " + id));
        Yayinevi yayinevi = yayineviRepository.findById(request.getYayineviNo())
                .orElseThrow(() -> new RuntimeException("Yayinevi bulunamadı"));

        y.setYazarAd(request.getYazarAd());
        y.setUlke(request.getUlke());
        y.setYayinevi(yayinevi);
        yazarRepository.save(y);

        YazarResponse response = new YazarResponse();
        response.setYazarNo(y.getYazarNo());
        response.setYazarAd(y.getYazarAd());
        response.setUlke(y.getUlke());
        response.setYayineviNo(y.getYayinevi().getYayineviNo());
        return response;
    }

    public void delete(UUID id) {
        Yazar y = yazarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Yazar bulunamadı: " + id));
        yazarRepository.delete(y);
    }
}

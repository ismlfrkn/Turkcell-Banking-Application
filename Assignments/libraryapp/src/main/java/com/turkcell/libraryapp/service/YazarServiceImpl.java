package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.yazar.request.YazarCreateRequest;
import com.turkcell.libraryapp.dto.yazar.request.YazarUpdateRequest;
import com.turkcell.libraryapp.dto.yazar.response.CreatedYazarResponse;
import com.turkcell.libraryapp.dto.yazar.response.GetByIdYazarResponse;
import com.turkcell.libraryapp.dto.yazar.response.ListYazarResponse;
import com.turkcell.libraryapp.dto.yazar.response.UpdatedYazarResponse;
import com.turkcell.libraryapp.entity.Yayinevi;
import com.turkcell.libraryapp.entity.Yazar;
import com.turkcell.libraryapp.repository.YazarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class YazarServiceImpl {

    private final YazarRepository yazarRepository;
    private final YayineviServiceImpl yayineviService;

    public YazarServiceImpl(
            YazarRepository yazarRepository,
            YayineviServiceImpl yayineviService
    ) {
        this.yazarRepository = yazarRepository;
        this.yayineviService = yayineviService;
    }

    public CreatedYazarResponse create(YazarCreateRequest request) {
        Yayinevi yayinevi = yayineviService.getEntityById(request.yayineviId());

        Yazar yazar = new Yazar();
        yazar.setYazarAd(request.yazarAd());
        yazar.setUlke(request.ulke());
        yazar.setYayinevi(yayinevi);

        Yazar savedYazar = yazarRepository.save(yazar);

        return new CreatedYazarResponse(
                savedYazar.getYazarNo(),
                savedYazar.getYazarAd(),
                savedYazar.getUlke(),
                savedYazar.getYayinevi().getYayineviNo()
        );
    }

    public UpdatedYazarResponse update(UUID id, YazarUpdateRequest request) {
        Yazar yazar = getEntityById(id);
        Yayinevi yayinevi = yayineviService.getEntityById(request.yayineviId());

        yazar.setYazarAd(request.yazarAd());
        yazar.setUlke(request.ulke());
        yazar.setYayinevi(yayinevi);

        Yazar updatedYazar = yazarRepository.save(yazar);

        return new UpdatedYazarResponse(
                updatedYazar.getYazarNo(),
                updatedYazar.getYazarAd(),
                updatedYazar.getUlke(),
                updatedYazar.getYayinevi().getYayineviNo()
        );
    }

    public GetByIdYazarResponse getById(UUID id) {
        Yazar yazar = getEntityById(id);

        return new GetByIdYazarResponse(
                yazar.getYazarNo(),
                yazar.getYazarAd(),
                yazar.getUlke(),
                yazar.getYayinevi().getYayineviNo(),
                yazar.getYayinevi().getYayineviAd()
        );
    }

    public List<ListYazarResponse> getAll() {
        return yazarRepository.findAll()
                .stream()
                .map(yazar -> new ListYazarResponse(
                        yazar.getYazarNo(),
                        yazar.getYazarAd(),
                        yazar.getUlke(),
                        yazar.getYayinevi().getYayineviAd()
                ))
                .toList();
    }

    public void delete(UUID id) {
        Yazar yazar = getEntityById(id);
        yazarRepository.delete(yazar);
    }

    // 🔥 diğer serviceler için
    public Yazar getEntityById(UUID id) {
        return yazarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Yazar bulunamadı."));
    }
}
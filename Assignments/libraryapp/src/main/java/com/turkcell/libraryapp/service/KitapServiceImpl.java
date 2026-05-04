package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.kitap.request.KitapCreateRequest;
import com.turkcell.libraryapp.dto.kitap.request.KitapUpdateRequest;
import com.turkcell.libraryapp.dto.kitap.response.CreatedKitapResponse;
import com.turkcell.libraryapp.dto.kitap.response.GetByIdKitapResponse;
import com.turkcell.libraryapp.dto.kitap.response.ListKitapResponse;
import com.turkcell.libraryapp.dto.kitap.response.UpdatedKitapResponse;
import com.turkcell.libraryapp.entity.Kitap;
import com.turkcell.libraryapp.entity.Yayinevi;
import com.turkcell.libraryapp.entity.Yazar;
import com.turkcell.libraryapp.repository.KitapRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KitapServiceImpl {

    private final KitapRepository kitapRepository;
    private final YayineviServiceImpl yayineviService;
    private final YazarServiceImpl yazarService;

    public KitapServiceImpl(
            KitapRepository kitapRepository,
            YayineviServiceImpl yayineviService,
            YazarServiceImpl yazarService
    ) {
        this.kitapRepository = kitapRepository;
        this.yayineviService = yayineviService;
        this.yazarService = yazarService;
    }

    public CreatedKitapResponse create(KitapCreateRequest request) {
        Yayinevi yayinevi = yayineviService.getEntityById(request.yayineviId());
        Yazar yazar = yazarService.getEntityById(request.yazarId());

        Kitap kitap = new Kitap();
        kitap.setKitapAd(request.kitapAd());
        kitap.setKitapTur(request.kitapTur());
        kitap.setSayfaSayi(request.sayfaSayi());
        kitap.setYayinevi(yayinevi);
        kitap.setYazar(yazar);

        Kitap savedKitap = kitapRepository.save(kitap);

        return new CreatedKitapResponse(
                savedKitap.getKitapId(),
                savedKitap.getKitapAd(),
                savedKitap.getKitapTur(),
                savedKitap.getSayfaSayi(),
                savedKitap.getYayinevi().getYayineviNo(),
                savedKitap.getYazar().getYazarNo()
        );
    }

    public UpdatedKitapResponse update(UUID id, KitapUpdateRequest request) {
        Kitap kitap = getKitapEntityById(id);

        Yayinevi yayinevi = yayineviService.getEntityById(request.yayineviId());
        Yazar yazar = yazarService.getEntityById(request.yazarId());

        kitap.setKitapAd(request.kitapAd());
        kitap.setKitapTur(request.kitapTur());
        kitap.setSayfaSayi(request.sayfaSayi());
        kitap.setYayinevi(yayinevi);
        kitap.setYazar(yazar);

        Kitap updatedKitap = kitapRepository.save(kitap);

        return new UpdatedKitapResponse(
                updatedKitap.getKitapId(),
                updatedKitap.getKitapAd(),
                updatedKitap.getKitapTur(),
                updatedKitap.getSayfaSayi(),
                updatedKitap.getYayinevi().getYayineviNo(),
                updatedKitap.getYazar().getYazarNo()
        );
    }

    public GetByIdKitapResponse getById(UUID id) {
        Kitap kitap = getKitapEntityById(id);

        return new GetByIdKitapResponse(
                kitap.getKitapId(),
                kitap.getKitapAd(),
                kitap.getKitapTur(),
                kitap.getSayfaSayi(),
                kitap.getYayinevi().getYayineviNo(),
                kitap.getYayinevi().getYayineviAd(),
                kitap.getYazar().getYazarNo(),
                kitap.getYazar().getYazarAd()
        );
    }

    public List<ListKitapResponse> getAll() {
        return kitapRepository.findAll()
                .stream()
                .map(kitap -> new ListKitapResponse(
                        kitap.getKitapId(),
                        kitap.getKitapAd(),
                        kitap.getKitapTur(),
                        kitap.getSayfaSayi(),
                        kitap.getYayinevi().getYayineviAd(),
                        kitap.getYazar().getYazarAd()
                ))
                .toList();
    }

    public void delete(UUID id) {
        Kitap kitap = getKitapEntityById(id);
        kitapRepository.delete(kitap);
    }

    public Kitap getKitapEntityById(UUID id) {
        return kitapRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı."));
    }
}
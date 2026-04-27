package com.turkcell.libraryapplication.service;

import com.turkcell.libraryapplication.dto.request.CreateKitapRequest;
import com.turkcell.libraryapplication.dto.request.UpdateKitapRequest;
import com.turkcell.libraryapplication.dto.response.KitapResponse;
import com.turkcell.libraryapplication.entity.Kitap;
import com.turkcell.libraryapplication.entity.Yayinevi;
import com.turkcell.libraryapplication.entity.Yazar;
import com.turkcell.libraryapplication.repository.KitapRepository;
import com.turkcell.libraryapplication.repository.YayineviRepository;
import com.turkcell.libraryapplication.repository.YazarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KitapServiceImpl {

        private final KitapRepository kitapRepository;
        private final YayineviRepository yayineviRepository;
        private final YazarRepository yazarRepository;

        public KitapServiceImpl(KitapRepository kitapRepository,
                        YayineviRepository yayineviRepository,
                        YazarRepository yazarRepository) {
                this.kitapRepository = kitapRepository;
                this.yayineviRepository = yayineviRepository;
                this.yazarRepository = yazarRepository;
        }

        public List<KitapResponse> getAll() {
                return kitapRepository.findAll()
                                .stream()
                                .map(kitap -> {
                                        KitapResponse response = new KitapResponse();
                                        response.setKitapID(kitap.getKitapID());
                                        response.setKitapAd(kitap.getKitapAd());
                                        response.setSayfaSayisi(kitap.getSayfaSayisi());
                                        response.setKitapTuru(kitap.getKitapTuru());
                                        response.setYayineviNo(kitap.getYayinevi().getYayineviNo());
                                        response.setYazarNo(kitap.getYazar().getYazarNo());
                                        return response;
                                })
                                .toList();
        }

        public KitapResponse getById(UUID id) {
                Kitap kitap = kitapRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı: " + id));

                KitapResponse response = new KitapResponse();
                response.setKitapID(kitap.getKitapID());
                response.setKitapAd(kitap.getKitapAd());
                response.setSayfaSayisi(kitap.getSayfaSayisi());
                response.setKitapTuru(kitap.getKitapTuru());
                response.setYayineviNo(kitap.getYayinevi().getYayineviNo());
                response.setYazarNo(kitap.getYazar().getYazarNo());

                return response;
        }

        public KitapResponse add(CreateKitapRequest request) {
                Yayinevi yayinevi = yayineviRepository.findById(request.getYayineviNo())
                                .orElseThrow(() -> new RuntimeException("Yayinevi bulunamadı"));
                Yazar yazar = yazarRepository.findById(request.getYazarNo())
                                .orElseThrow(() -> new RuntimeException("Yazar bulunamadı"));

                Kitap kitap = new Kitap();
                kitap.setKitapAd(request.getKitapAd());
                kitap.setSayfaSayisi(request.getSayfaSayisi());
                kitap.setKitapTuru(request.getKitapTuru());
                kitap.setYayinevi(yayinevi);
                kitap.setYazar(yazar);
                kitapRepository.save(kitap);

                KitapResponse response = new KitapResponse();
                response.setKitapID(kitap.getKitapID());
                response.setKitapAd(kitap.getKitapAd());
                response.setSayfaSayisi(kitap.getSayfaSayisi());
                response.setKitapTuru(kitap.getKitapTuru());
                response.setYayineviNo(kitap.getYayinevi().getYayineviNo());
                response.setYazarNo(kitap.getYazar().getYazarNo());

                return response;
        }

        public KitapResponse update(UUID id, UpdateKitapRequest request) {
                Kitap kitap = kitapRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı: " + id));

                Yayinevi yayinevi = yayineviRepository.findById(request.getYayineviNo())
                                .orElseThrow(() -> new RuntimeException("Yayinevi bulunamadı"));
                Yazar yazar = yazarRepository.findById(request.getYazarNo())
                                .orElseThrow(() -> new RuntimeException("Yazar bulunamadı"));

                kitap.setKitapAd(request.getKitapAd());
                kitap.setSayfaSayisi(request.getSayfaSayisi());
                kitap.setKitapTuru(request.getKitapTuru());
                kitap.setYayinevi(yayinevi);
                kitap.setYazar(yazar);
                kitapRepository.save(kitap);

                KitapResponse response = new KitapResponse();
                response.setKitapID(kitap.getKitapID());
                response.setKitapAd(kitap.getKitapAd());
                response.setSayfaSayisi(kitap.getSayfaSayisi());
                response.setKitapTuru(kitap.getKitapTuru());
                response.setYayineviNo(kitap.getYayinevi().getYayineviNo());
                response.setYazarNo(kitap.getYazar().getYazarNo());

                return response;
        }

        public void delete(UUID id) {
                Kitap kitap = kitapRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı: " + id));
                kitapRepository.delete(kitap);
        }
}

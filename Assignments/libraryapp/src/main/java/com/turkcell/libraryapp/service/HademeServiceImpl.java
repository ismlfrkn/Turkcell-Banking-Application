package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.hademe.request.HademeCreateRequest;
import com.turkcell.libraryapp.dto.hademe.request.HademeUpdateRequest;
import com.turkcell.libraryapp.dto.hademe.response.CreatedHademeResponse;
import com.turkcell.libraryapp.dto.hademe.response.GetByIdHademeResponse;
import com.turkcell.libraryapp.dto.hademe.response.ListHademeResponse;
import com.turkcell.libraryapp.dto.hademe.response.UpdatedHademeResponse;
import com.turkcell.libraryapp.entity.Hademe;
import com.turkcell.libraryapp.entity.Kutuphane;
import com.turkcell.libraryapp.repository.HademeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HademeServiceImpl {

    private final HademeRepository hademeRepository;
    private final KutuphaneServiceImpl kutuphaneService;

    public HademeServiceImpl(
            HademeRepository hademeRepository,
            KutuphaneServiceImpl kutuphaneService
    ) {
        this.hademeRepository = hademeRepository;
        this.kutuphaneService = kutuphaneService;
    }

    public CreatedHademeResponse create(HademeCreateRequest request) {
        Kutuphane kutuphane = kutuphaneService.getEntityById(request.kutuphaneId());

        Hademe hademe = new Hademe();
        hademe.setPersonelAd(request.personelAd());
        hademe.setGorevBaslangic(request.gorevBaslangic());
        hademe.setKutuphane(kutuphane);
        hademe.setHademeMaas(request.hademeMaas());
        hademe.setVardiyaTuru(request.vardiyaTuru());
        hademe.setTemizlikBolgesi(request.temizlikBolgesi());

        Hademe saved = hademeRepository.save(hademe);

        return new CreatedHademeResponse(
                saved.getPersonelNo(),
                saved.getPersonelAd(),
                saved.getGorevBaslangic(),
                saved.getKutuphane().getKutuphaneId(),
                saved.getHademeMaas(),
                saved.getVardiyaTuru(),
                saved.getTemizlikBolgesi()
        );
    }

    public UpdatedHademeResponse update(UUID id, HademeUpdateRequest request) {
        Hademe hademe = getEntityById(id);
        Kutuphane kutuphane = kutuphaneService.getEntityById(request.kutuphaneId());

        hademe.setPersonelAd(request.personelAd());
        hademe.setGorevBaslangic(request.gorevBaslangic());
        hademe.setKutuphane(kutuphane);
        hademe.setHademeMaas(request.hademeMaas());
        hademe.setVardiyaTuru(request.vardiyaTuru());
        hademe.setTemizlikBolgesi(request.temizlikBolgesi());

        Hademe updated = hademeRepository.save(hademe);

        return new UpdatedHademeResponse(
                updated.getPersonelNo(),
                updated.getPersonelAd(),
                updated.getGorevBaslangic(),
                updated.getKutuphane().getKutuphaneId(),
                updated.getHademeMaas(),
                updated.getVardiyaTuru(),
                updated.getTemizlikBolgesi()
        );
    }

    public GetByIdHademeResponse getById(UUID id) {
        Hademe hademe = getEntityById(id);

        return new GetByIdHademeResponse(
                hademe.getPersonelNo(),
                hademe.getPersonelAd(),
                hademe.getGorevBaslangic(),
                hademe.getKutuphane().getKutuphaneId(),
                hademe.getKutuphane().getKutuphaneAd(),
                hademe.getHademeMaas(),
                hademe.getVardiyaTuru(),
                hademe.getTemizlikBolgesi()
        );
    }

    public List<ListHademeResponse> getAll() {
        return hademeRepository.findAll()
                .stream()
                .map(hademe -> new ListHademeResponse(
                        hademe.getPersonelNo(),
                        hademe.getPersonelAd(),
                        hademe.getGorevBaslangic(),
                        hademe.getKutuphane().getKutuphaneAd(),
                        hademe.getHademeMaas(),
                        hademe.getVardiyaTuru(),
                        hademe.getTemizlikBolgesi()
                ))
                .toList();
    }

    public void delete(UUID id) {
        Hademe hademe = getEntityById(id);
        hademeRepository.delete(hademe);
    }

    public Hademe getEntityById(UUID id) {
        return hademeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hademe bulunamadı."));
    }
}
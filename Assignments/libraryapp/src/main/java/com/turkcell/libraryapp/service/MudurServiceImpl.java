package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.mudur.request.MudurCreateRequest;
import com.turkcell.libraryapp.entity.Mudur;
import com.turkcell.libraryapp.entity.Kutuphane;
import com.turkcell.libraryapp.repository.MudurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MudurServiceImpl {

    private final MudurRepository mudurRepository;
    private final KutuphaneServiceImpl kutuphaneService;

    public MudurServiceImpl(
            MudurRepository mudurRepository,
            KutuphaneServiceImpl kutuphaneService
    ) {
        this.mudurRepository = mudurRepository;
        this.kutuphaneService = kutuphaneService;
    }

    public Mudur create(MudurCreateRequest request) {

        Kutuphane kutuphane = kutuphaneService.getEntityById(request.kutuphaneId());

        Mudur mudur = new Mudur();
        mudur.setPersonelAd(request.personelAd());
        mudur.setGorevBaslangic(request.gorevBaslangic());
        mudur.setMudurMaas(request.mudurMaas());
        mudur.setDiplomaAlani(request.diplomaAlani());
        mudur.setKutuphane(kutuphane);

        return mudurRepository.save(mudur);
    }

    public List<Mudur> getAll() {
        return mudurRepository.findAll();
    }

    public Mudur getById(UUID id) {
        return getEntityById(id);
    }

    public void delete(UUID id) {
        Mudur mudur = getEntityById(id);
        mudurRepository.delete(mudur);
    }

    // 🔥 diğer serviceler için
    public Mudur getEntityById(UUID id) {
        return mudurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Müdür bulunamadı."));
    }
}
package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.kutuphanesorumlusu.request.KutuphaneSorumlusuCreateRequest;
import com.turkcell.libraryapp.entity.Kutuphane;
import com.turkcell.libraryapp.entity.KutuphaneSorumlusu;
import com.turkcell.libraryapp.repository.KutuphaneSorumlusuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KutuphaneSorumlusuServiceImpl {

    private final KutuphaneSorumlusuRepository repository;
    private final KutuphaneServiceImpl kutuphaneService;

    public KutuphaneSorumlusuServiceImpl(
            KutuphaneSorumlusuRepository repository,
            KutuphaneServiceImpl kutuphaneService
    ) {
        this.repository = repository;
        this.kutuphaneService = kutuphaneService;
    }

    public KutuphaneSorumlusu create(KutuphaneSorumlusuCreateRequest request) {

        Kutuphane kutuphane = kutuphaneService.getEntityById(request.kutuphaneId());

        KutuphaneSorumlusu entity = new KutuphaneSorumlusu();
        entity.setPersonelAd(request.personelAd());
        entity.setGorevBaslangic(request.gorevBaslangic());
        entity.setKutuphane(kutuphane);

        return repository.save(entity);
    }

    public List<KutuphaneSorumlusu> getAll() {
        return repository.findAll();
    }

    public KutuphaneSorumlusu getById(UUID id) {
        return getEntityById(id);
    }

    public void delete(UUID id) {
        KutuphaneSorumlusu entity = getEntityById(id);
        repository.delete(entity);
    }

    public KutuphaneSorumlusu getEntityById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kütüphane sorumlusu bulunamadı."));
    }
}
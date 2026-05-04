package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.kutuphane.request.KutuphaneCreateRequest;
import com.turkcell.libraryapp.dto.kutuphane.request.KutuphaneUpdateRequest;
import com.turkcell.libraryapp.dto.kutuphane.response.CreatedKutuphaneResponse;
import com.turkcell.libraryapp.dto.kutuphane.response.GetByIdKutuphaneResponse;
import com.turkcell.libraryapp.dto.kutuphane.response.ListKutuphaneResponse;
import com.turkcell.libraryapp.dto.kutuphane.response.UpdatedKutuphaneResponse;
import com.turkcell.libraryapp.entity.Adres;
import com.turkcell.libraryapp.entity.Kutuphane;
import com.turkcell.libraryapp.repository.KutuphaneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KutuphaneServiceImpl {

    private final KutuphaneRepository kutuphaneRepository;
    private final AdresServiceImpl adresService;

    public KutuphaneServiceImpl(
            KutuphaneRepository kutuphaneRepository,
            AdresServiceImpl adresService
    ) {
        this.kutuphaneRepository = kutuphaneRepository;
        this.adresService = adresService;
    }

    public CreatedKutuphaneResponse create(KutuphaneCreateRequest request) {
        Adres adres = adresService.getEntityById(request.ilKodu());

        Kutuphane kutuphane = new Kutuphane();
        kutuphane.setKutuphaneAd(request.kutuphaneAd());
        kutuphane.setTelefonNo(request.telefonNo());
        kutuphane.setAcilisSaati(request.acilisSaati());
        kutuphane.setKapanisSaati(request.kapanisSaati());
        kutuphane.setAdres(adres);

        Kutuphane savedKutuphane = kutuphaneRepository.save(kutuphane);

        return new CreatedKutuphaneResponse(
                savedKutuphane.getKutuphaneId(),
                savedKutuphane.getKutuphaneAd(),
                savedKutuphane.getTelefonNo(),
                savedKutuphane.getAcilisSaati(),
                savedKutuphane.getKapanisSaati(),
                savedKutuphane.getAdres().getIlKod()
        );
    }

    public UpdatedKutuphaneResponse update(UUID id, KutuphaneUpdateRequest request) {
        Kutuphane kutuphane = getEntityById(id);
        Adres adres = adresService.getEntityById(request.ilKodu());

        kutuphane.setKutuphaneAd(request.kutuphaneAd());
        kutuphane.setTelefonNo(request.telefonNo());
        kutuphane.setAcilisSaati(request.acilisSaati());
        kutuphane.setKapanisSaati(request.kapanisSaati());
        kutuphane.setAdres(adres);

        Kutuphane updatedKutuphane = kutuphaneRepository.save(kutuphane);

        return new UpdatedKutuphaneResponse(
                updatedKutuphane.getKutuphaneId(),
                updatedKutuphane.getKutuphaneAd(),
                updatedKutuphane.getTelefonNo(),
                updatedKutuphane.getAcilisSaati(),
                updatedKutuphane.getKapanisSaati(),
                updatedKutuphane.getAdres().getIlKod()
        );
    }

    public GetByIdKutuphaneResponse getById(UUID id) {
        Kutuphane kutuphane = getEntityById(id);

        return new GetByIdKutuphaneResponse(
                kutuphane.getKutuphaneId(),
                kutuphane.getKutuphaneAd(),
                kutuphane.getTelefonNo(),
                kutuphane.getAcilisSaati(),
                kutuphane.getKapanisSaati(),
                kutuphane.getAdres().getIlKod(),
                kutuphane.getAdres().getIlAd(),
                kutuphane.getAdres().getIlceAd(),
                kutuphane.getAdres().getBolge()
        );
    }

    public List<ListKutuphaneResponse> getAll() {
        return kutuphaneRepository.findAll()
                .stream()
                .map(kutuphane -> new ListKutuphaneResponse(
                        kutuphane.getKutuphaneId(),
                        kutuphane.getKutuphaneAd(),
                        kutuphane.getTelefonNo(),
                        kutuphane.getAcilisSaati(),
                        kutuphane.getKapanisSaati(),
                        kutuphane.getAdres().getIlAd()
                ))
                .toList();
    }

    public void delete(UUID id) {
        Kutuphane kutuphane = getEntityById(id);
        kutuphaneRepository.delete(kutuphane);
    }

    public Kutuphane getEntityById(UUID id) {
        return kutuphaneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kütüphane bulunamadı."));
    }
}
package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.yayinevi.request.YayineviCreateRequest;
import com.turkcell.libraryapp.dto.yayinevi.request.YayineviUpdateRequest;
import com.turkcell.libraryapp.dto.yayinevi.response.CreatedYayineviResponse;
import com.turkcell.libraryapp.dto.yayinevi.response.GetByIdYayineviResponse;
import com.turkcell.libraryapp.dto.yayinevi.response.ListYayineviResponse;
import com.turkcell.libraryapp.dto.yayinevi.response.UpdatedYayineviResponse;
import com.turkcell.libraryapp.entity.Adres;
import com.turkcell.libraryapp.entity.Yayinevi;
import com.turkcell.libraryapp.repository.YayineviRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class YayineviServiceImpl {

    private final YayineviRepository yayineviRepository;
    private final AdresServiceImpl adresService;

    public YayineviServiceImpl(
            YayineviRepository yayineviRepository,
            AdresServiceImpl adresService
    ) {
        this.yayineviRepository = yayineviRepository;
        this.adresService = adresService;
    }

    public CreatedYayineviResponse create(YayineviCreateRequest request) {
        Adres adres = adresService.getEntityById(request.ilKodu());

        Yayinevi yayinevi = new Yayinevi();
        yayinevi.setYayineviAd(request.yayineviAd());
        yayinevi.setTelefonNo(request.telefonNo());
        yayinevi.setAdres(adres);

        Yayinevi savedYayinevi = yayineviRepository.save(yayinevi);

        return new CreatedYayineviResponse(
                savedYayinevi.getYayineviNo(),
                savedYayinevi.getYayineviAd(),
                savedYayinevi.getTelefonNo(),
                savedYayinevi.getAdres().getIlKod()
        );
    }

    public UpdatedYayineviResponse update(UUID id, YayineviUpdateRequest request) {
        Yayinevi yayinevi = getEntityById(id);
        Adres adres = adresService.getEntityById(request.ilKodu());

        yayinevi.setYayineviAd(request.yayineviAd());
        yayinevi.setTelefonNo(request.telefonNo());
        yayinevi.setAdres(adres);

        Yayinevi updatedYayinevi = yayineviRepository.save(yayinevi);

        return new UpdatedYayineviResponse(
                updatedYayinevi.getYayineviNo(),
                updatedYayinevi.getYayineviAd(),
                updatedYayinevi.getTelefonNo(),
                updatedYayinevi.getAdres().getIlKod()
        );
    }

    public GetByIdYayineviResponse getById(UUID id) {
        Yayinevi yayinevi = getEntityById(id);

        return new GetByIdYayineviResponse(
                yayinevi.getYayineviNo(),
                yayinevi.getYayineviAd(),
                yayinevi.getTelefonNo(),
                yayinevi.getAdres().getIlKod(),
                yayinevi.getAdres().getIlAd(),
                yayinevi.getAdres().getIlceAd(),
                yayinevi.getAdres().getBolge()
        );
    }

    public List<ListYayineviResponse> getAll() {
        return yayineviRepository.findAll()
                .stream()
                .map(yayinevi -> new ListYayineviResponse(
                        yayinevi.getYayineviNo(),
                        yayinevi.getYayineviAd(),
                        yayinevi.getTelefonNo(),
                        yayinevi.getAdres().getIlKod(),
                        yayinevi.getAdres().getIlAd()
                ))
                .toList();
    }

    public void delete(UUID id) {
        Yayinevi yayinevi = getEntityById(id);
        yayineviRepository.delete(yayinevi);
    }

    public Yayinevi getEntityById(UUID id) {
        return yayineviRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Yayınevi bulunamadı."));
    }
}
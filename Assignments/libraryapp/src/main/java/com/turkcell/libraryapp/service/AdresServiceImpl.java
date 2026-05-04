package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.adres.request.AdresCreateRequest;
import com.turkcell.libraryapp.dto.adres.request.AdresUpdateRequest;
import com.turkcell.libraryapp.dto.adres.response.CreatedAdresResponse;
import com.turkcell.libraryapp.dto.adres.response.GetByIdAdresResponse;
import com.turkcell.libraryapp.dto.adres.response.ListAdresResponse;
import com.turkcell.libraryapp.dto.adres.response.UpdatedAdresResponse;
import com.turkcell.libraryapp.entity.Adres;
import com.turkcell.libraryapp.repository.AdresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresServiceImpl {

    private final AdresRepository adresRepository;

    public AdresServiceImpl(AdresRepository adresRepository) {
        this.adresRepository = adresRepository;
    }

    public CreatedAdresResponse create(AdresCreateRequest request) {
        Adres adres = new Adres();

        adres.setIlKod(request.ilKod());
        adres.setIlAd(request.ilAd());
        adres.setIlceAd(request.ilceAd());
        adres.setBolge(request.bolge());

        Adres savedAdres = adresRepository.save(adres);

        return new CreatedAdresResponse(
                savedAdres.getIlKod(),
                savedAdres.getIlAd(),
                savedAdres.getIlceAd(),
                savedAdres.getBolge()
        );
    }

    public UpdatedAdresResponse update(int ilKodu, AdresUpdateRequest request) {
        Adres adres = adresRepository.findById(ilKodu)
                .orElseThrow(() -> new RuntimeException("Adres bulunamadı."));

        adres.setIlAd(request.ilAd());
        adres.setIlceAd(request.ilceAd());
        adres.setBolge(request.bolge());

        Adres updatedAdres = adresRepository.save(adres);

        return new UpdatedAdresResponse(
                updatedAdres.getIlKod(),
                updatedAdres.getIlAd(),
                updatedAdres.getIlceAd(),
                updatedAdres.getBolge()
        );
    }

    public GetByIdAdresResponse getById(int ilKodu) {
        Adres adres = adresRepository.findById(ilKodu)
                .orElseThrow(() -> new RuntimeException("Adres bulunamadı."));

        return new GetByIdAdresResponse(
                adres.getIlKod(),
                adres.getIlAd(),
                adres.getIlceAd(),
                adres.getBolge()
        );
    }

    public List<ListAdresResponse> getAll() {
        return adresRepository.findAll()
                .stream()
                .map(adres -> new ListAdresResponse(
                        adres.getIlKod(),
                        adres.getIlAd(),
                        adres.getIlceAd(),
                        adres.getBolge()
                ))
                .toList();
    }

    public void delete(int ilKodu) {
        Adres adres = adresRepository.findById(ilKodu)
                .orElseThrow(() -> new RuntimeException("Adres bulunamadı."));

        adresRepository.delete(adres);
    }

    public Adres getEntityById(int id) {
    return adresRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Adres bulunamadı."));
}
}
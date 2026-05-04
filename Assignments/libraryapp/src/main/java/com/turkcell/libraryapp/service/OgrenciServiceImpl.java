package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.ogrenci.request.OgrenciCreateRequest;
import com.turkcell.libraryapp.dto.ogrenci.request.OgrenciUpdateRequest;
import com.turkcell.libraryapp.dto.ogrenci.response.CreatedOgrenciResponse;
import com.turkcell.libraryapp.dto.ogrenci.response.GetByIdOgrenciResponse;
import com.turkcell.libraryapp.dto.ogrenci.response.ListOgrenciResponse;
import com.turkcell.libraryapp.dto.ogrenci.response.UpdatedOgrenciResponse;
import com.turkcell.libraryapp.entity.Ogrenci;
import com.turkcell.libraryapp.repository.OgrenciRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OgrenciServiceImpl {

    private final OgrenciRepository ogrenciRepository;

    public OgrenciServiceImpl(OgrenciRepository ogrenciRepository) {
        this.ogrenciRepository = ogrenciRepository;
    }

    public CreatedOgrenciResponse create(OgrenciCreateRequest request) {
        Ogrenci ogrenci = new Ogrenci();
        ogrenci.setOgrenciAd(request.ogrenciAd());
        ogrenci.setEmail(request.email());

        Ogrenci savedOgrenci = ogrenciRepository.save(ogrenci);

        return new CreatedOgrenciResponse(
                savedOgrenci.getOgrenciId(),
                savedOgrenci.getOgrenciAd(),
                savedOgrenci.getEmail()
        );
    }

    public UpdatedOgrenciResponse update(UUID id, OgrenciUpdateRequest request) {
        Ogrenci ogrenci = ogrenciRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Öğrenci bulunamadı."));

        ogrenci.setOgrenciAd(request.ogrenciAd());
        ogrenci.setEmail(request.email());

        Ogrenci updatedOgrenci = ogrenciRepository.save(ogrenci);

        return new UpdatedOgrenciResponse(
                updatedOgrenci.getOgrenciId(),
                updatedOgrenci.getOgrenciAd(),
                updatedOgrenci.getEmail()
        );
    }

    public GetByIdOgrenciResponse getById(UUID id) {
        Ogrenci ogrenci = ogrenciRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Öğrenci bulunamadı."));

        return new GetByIdOgrenciResponse(
                ogrenci.getOgrenciId(),
                ogrenci.getOgrenciAd(),
                ogrenci.getEmail()
        );
    }

    public List<ListOgrenciResponse> getAll() {
        return ogrenciRepository.findAll()
                .stream()
                .map(ogrenci -> new ListOgrenciResponse(
                        ogrenci.getOgrenciId(),
                        ogrenci.getOgrenciAd(),
                        ogrenci.getEmail()
                ))
                .toList();
    }

    public void delete(UUID id) {
        Ogrenci ogrenci = ogrenciRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Öğrenci bulunamadı."));

        ogrenciRepository.delete(ogrenci);
    }
    public Ogrenci getEntityById(UUID id) {
    return ogrenciRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Öğrenci bulunamadı."));
}
}
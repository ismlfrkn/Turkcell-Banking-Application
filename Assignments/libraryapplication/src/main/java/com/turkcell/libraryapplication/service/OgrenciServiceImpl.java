package com.turkcell.libraryapplication.service;

import com.turkcell.libraryapplication.dto.request.CreateOgrenciRequest;
import com.turkcell.libraryapplication.dto.request.UpdateOgrenciRequest;
import com.turkcell.libraryapplication.dto.response.OgrenciResponse;
import com.turkcell.libraryapplication.entity.Ogrenci;
import com.turkcell.libraryapplication.repository.OgrenciRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OgrenciServiceImpl {

    private final OgrenciRepository ogrenciRepository;

    public OgrenciServiceImpl(OgrenciRepository ogrenciRepository) {
        this.ogrenciRepository = ogrenciRepository;
    }

    public List<OgrenciResponse> getAll() {
        return ogrenciRepository.findAll()
                .stream()
                .map(o -> {
                    OgrenciResponse response = new OgrenciResponse();
                    response.setOgrenciID(o.getOgrenciID());
                    response.setOgrenciAd(o.getOgrenciAd());
                    response.setEmail(o.getEmail());
                    return response;
                })
                .toList();
    }

    public OgrenciResponse getById(UUID id) {
        Ogrenci o = ogrenciRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ogrenci bulunamadı: " + id));

        OgrenciResponse response = new OgrenciResponse();
        response.setOgrenciID(o.getOgrenciID());
        response.setOgrenciAd(o.getOgrenciAd());
        response.setEmail(o.getEmail());
        return response;
    }

    public OgrenciResponse add(CreateOgrenciRequest request) {
        Ogrenci o = new Ogrenci();
        o.setOgrenciAd(request.getOgrenciAd());
        o.setEmail(request.getEmail());
        ogrenciRepository.save(o);

        OgrenciResponse response = new OgrenciResponse();
        response.setOgrenciID(o.getOgrenciID());
        response.setOgrenciAd(o.getOgrenciAd());
        response.setEmail(o.getEmail());
        return response;
    }

    public OgrenciResponse update(UUID id, UpdateOgrenciRequest request) {
        Ogrenci o = ogrenciRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ogrenci bulunamadı: " + id));

        o.setOgrenciAd(request.getOgrenciAd());
        o.setEmail(request.getEmail());
        ogrenciRepository.save(o);

        OgrenciResponse response = new OgrenciResponse();
        response.setOgrenciID(o.getOgrenciID());
        response.setOgrenciAd(o.getOgrenciAd());
        response.setEmail(o.getEmail());
        return response;
    }

    public void delete(UUID id) {
        Ogrenci o = ogrenciRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ogrenci bulunamadı: " + id));
        ogrenciRepository.delete(o);
    }
}

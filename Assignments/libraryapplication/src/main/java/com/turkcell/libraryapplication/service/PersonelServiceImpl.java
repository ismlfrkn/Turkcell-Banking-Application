package com.turkcell.libraryapplication.service;

import com.turkcell.libraryapplication.dto.request.CreatePersonelRequest;
import com.turkcell.libraryapplication.dto.request.UpdatePersonelRequest;
import com.turkcell.libraryapplication.dto.response.PersonelResponse;
import com.turkcell.libraryapplication.entity.Kutuphane;
import com.turkcell.libraryapplication.entity.Personel;
import com.turkcell.libraryapplication.repository.KutuphaneRepository;
import com.turkcell.libraryapplication.repository.PersonelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonelServiceImpl {

    private final PersonelRepository personelRepository;
    private final KutuphaneRepository kutuphaneRepository;

    public PersonelServiceImpl(PersonelRepository personelRepository, KutuphaneRepository kutuphaneRepository) {
        this.personelRepository = personelRepository;
        this.kutuphaneRepository = kutuphaneRepository;
    }

    public List<PersonelResponse> getAll() {
        return personelRepository.findAll()
                .stream()
                .map(p -> {
                    PersonelResponse response = new PersonelResponse();
                    response.setPersonelNo(p.getPersonelNo());
                    response.setPersonelAd(p.getPersonelAd());
                    response.setGorevBaslangic(p.getGorevBaslangic());
                    response.setMaas(p.getMaas());
                    response.setKutuphaneId(p.getKutuphane().getKutuphaneID());
                    return response;
                })
                .toList();
    }

    public PersonelResponse getById(UUID id) {
        Personel p = personelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personel bulunamadı: " + id));

        PersonelResponse response = new PersonelResponse();
        response.setPersonelNo(p.getPersonelNo());
        response.setPersonelAd(p.getPersonelAd());
        response.setGorevBaslangic(p.getGorevBaslangic());
        response.setMaas(p.getMaas());
        response.setKutuphaneId(p.getKutuphane().getKutuphaneID());
        return response;
    }

    public PersonelResponse add(CreatePersonelRequest request) {
        Kutuphane kutuphane = kutuphaneRepository.findById(request.getKutuphaneId())
                .orElseThrow(() -> new RuntimeException("Kutuphane bulunamadı"));

        Personel p = new Personel();
        p.setPersonelAd(request.getPersonelAd());
        p.setGorevBaslangic(request.getGorevBaslangic());
        p.setMaas(request.getMaas());
        p.setKutuphane(kutuphane);
        personelRepository.save(p);

        PersonelResponse response = new PersonelResponse();
        response.setPersonelNo(p.getPersonelNo());
        response.setPersonelAd(p.getPersonelAd());
        response.setGorevBaslangic(p.getGorevBaslangic());
        response.setMaas(p.getMaas());
        response.setKutuphaneId(p.getKutuphane().getKutuphaneID());
        return response;
    }

    public PersonelResponse update(UUID id, UpdatePersonelRequest request) {
        Personel p = personelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personel bulunamadı: " + id));
        Kutuphane kutuphane = kutuphaneRepository.findById(request.getKutuphaneId())
                .orElseThrow(() -> new RuntimeException("Kutuphane bulunamadı"));

        p.setPersonelAd(request.getPersonelAd());
        p.setGorevBaslangic(request.getGorevBaslangic());
        p.setMaas(request.getMaas());
        p.setKutuphane(kutuphane);
        personelRepository.save(p);

        PersonelResponse response = new PersonelResponse();
        response.setPersonelNo(p.getPersonelNo());
        response.setPersonelAd(p.getPersonelAd());
        response.setGorevBaslangic(p.getGorevBaslangic());
        response.setMaas(p.getMaas());
        response.setKutuphaneId(p.getKutuphane().getKutuphaneID());
        return response;
    }

    public void delete(UUID id) {
        Personel p = personelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personel bulunamadı: " + id));
        personelRepository.delete(p);
    }
}

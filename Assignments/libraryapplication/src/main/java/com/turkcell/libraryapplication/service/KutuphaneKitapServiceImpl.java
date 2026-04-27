package com.turkcell.libraryapplication.service;

import com.turkcell.libraryapplication.dto.request.CreateKutuphaneKitapRequest;
import com.turkcell.libraryapplication.dto.request.UpdateKutuphaneKitapRequest;
import com.turkcell.libraryapplication.dto.response.KutuphaneKitapResponse;
import com.turkcell.libraryapplication.entity.Kitap;
import com.turkcell.libraryapplication.entity.Kutuphane;
import com.turkcell.libraryapplication.entity.KutuphaneKitap;
import com.turkcell.libraryapplication.entity.KutuphaneKitapId;
import com.turkcell.libraryapplication.repository.KitapRepository;
import com.turkcell.libraryapplication.repository.KutuphaneKitapRepository;
import com.turkcell.libraryapplication.repository.KutuphaneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KutuphaneKitapServiceImpl {

    private final KutuphaneKitapRepository kutuphaneKitapRepository;
    private final KutuphaneRepository kutuphaneRepository;
    private final KitapRepository kitapRepository;

    public KutuphaneKitapServiceImpl(KutuphaneKitapRepository kutuphaneKitapRepository,
                                      KutuphaneRepository kutuphaneRepository,
                                      KitapRepository kitapRepository) {
        this.kutuphaneKitapRepository = kutuphaneKitapRepository;
        this.kutuphaneRepository = kutuphaneRepository;
        this.kitapRepository = kitapRepository;
    }

    public List<KutuphaneKitapResponse> getAll() {
        return kutuphaneKitapRepository.findAll()
                .stream()
                .map(kk -> {
                    KutuphaneKitapResponse response = new KutuphaneKitapResponse();
                    response.setKutuphaneId(kk.getKutuphane().getKutuphaneID());
                    response.setKitapId(kk.getKitap().getKitapID());
                    response.setStokMiktar(kk.getStokMiktar());
                    response.setEklemeTarihi(kk.getEklemeTarihi());
                    return response;
                })
                .toList();
    }

    public KutuphaneKitapResponse getById(UUID kutuphaneId, UUID kitapId) {
        KutuphaneKitapId id = new KutuphaneKitapId();
        id.setKutuphane(kutuphaneId);
        id.setKitap(kitapId);

        KutuphaneKitap kk = kutuphaneKitapRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KutuphaneKitap bulunamadı"));

        KutuphaneKitapResponse response = new KutuphaneKitapResponse();
        response.setKutuphaneId(kk.getKutuphane().getKutuphaneID());
        response.setKitapId(kk.getKitap().getKitapID());
        response.setStokMiktar(kk.getStokMiktar());
        response.setEklemeTarihi(kk.getEklemeTarihi());
        return response;
    }

    public KutuphaneKitapResponse add(CreateKutuphaneKitapRequest request) {
        Kutuphane kutuphane = kutuphaneRepository.findById(request.getKutuphaneId())
                .orElseThrow(() -> new RuntimeException("Kutuphane bulunamadı"));
        Kitap kitap = kitapRepository.findById(request.getKitapId())
                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı"));

        KutuphaneKitap kk = new KutuphaneKitap();
        kk.setKutuphane(kutuphane);
        kk.setKitap(kitap);
        kk.setStokMiktar(request.getStokMiktar());
        kk.setEklemeTarihi(request.getEklemeTarihi());
        kutuphaneKitapRepository.save(kk);

        KutuphaneKitapResponse response = new KutuphaneKitapResponse();
        response.setKutuphaneId(kk.getKutuphane().getKutuphaneID());
        response.setKitapId(kk.getKitap().getKitapID());
        response.setStokMiktar(kk.getStokMiktar());
        response.setEklemeTarihi(kk.getEklemeTarihi());
        return response;
    }

    public KutuphaneKitapResponse update(UUID kutuphaneId, UUID kitapId,
                                          UpdateKutuphaneKitapRequest request) {
        KutuphaneKitapId id = new KutuphaneKitapId();
        id.setKutuphane(kutuphaneId);
        id.setKitap(kitapId);

        KutuphaneKitap kk = kutuphaneKitapRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KutuphaneKitap bulunamadı"));

        kk.setStokMiktar(request.getStokMiktar());
        kk.setEklemeTarihi(request.getEklemeTarihi());
        kutuphaneKitapRepository.save(kk);

        KutuphaneKitapResponse response = new KutuphaneKitapResponse();
        response.setKutuphaneId(kk.getKutuphane().getKutuphaneID());
        response.setKitapId(kk.getKitap().getKitapID());
        response.setStokMiktar(kk.getStokMiktar());
        response.setEklemeTarihi(kk.getEklemeTarihi());
        return response;
    }

    public void delete(UUID kutuphaneId, UUID kitapId) {
        KutuphaneKitapId id = new KutuphaneKitapId();
        id.setKutuphane(kutuphaneId);
        id.setKitap(kitapId);

        KutuphaneKitap kk = kutuphaneKitapRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KutuphaneKitap bulunamadı"));
        kutuphaneKitapRepository.delete(kk);
    }
}

package com.turkcell.libraryapplication.service;

import com.turkcell.libraryapplication.dto.request.CreateOgrenciKitapRequest;
import com.turkcell.libraryapplication.dto.request.UpdateOgrenciKitapRequest;
import com.turkcell.libraryapplication.dto.response.OgrenciKitapResponse;
import com.turkcell.libraryapplication.entity.Kitap;
import com.turkcell.libraryapplication.entity.Ogrenci;
import com.turkcell.libraryapplication.entity.OgrenciKitap;
import com.turkcell.libraryapplication.entity.OgrenciKitapId;
import com.turkcell.libraryapplication.repository.KitapRepository;
import com.turkcell.libraryapplication.repository.OgrenciKitapRepository;
import com.turkcell.libraryapplication.repository.OgrenciRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OgrenciKitapServiceImpl {

    private final OgrenciKitapRepository ogrenciKitapRepository;
    private final OgrenciRepository ogrenciRepository;
    private final KitapRepository kitapRepository;

    public OgrenciKitapServiceImpl(OgrenciKitapRepository ogrenciKitapRepository,
                                    OgrenciRepository ogrenciRepository,
                                    KitapRepository kitapRepository) {
        this.ogrenciKitapRepository = ogrenciKitapRepository;
        this.ogrenciRepository = ogrenciRepository;
        this.kitapRepository = kitapRepository;
    }

    public List<OgrenciKitapResponse> getAll() {
        return ogrenciKitapRepository.findAll()
                .stream()
                .map(ok -> {
                    OgrenciKitapResponse response = new OgrenciKitapResponse();
                    response.setOgrenciId(ok.getOgrenci().getOgrenciID());
                    response.setKitapId(ok.getKitap().getKitapID());
                    response.setAlisTarihi(ok.getAlisTarihi());
                    response.setIadeTarihi(ok.getIadeTarihi());
                    response.setIadeDurumu(ok.isIadeDurumu());
                    return response;
                })
                .toList();
    }

    public OgrenciKitapResponse getById(UUID ogrenciId, UUID kitapId) {
        OgrenciKitapId id = new OgrenciKitapId();
        id.setOgrenci(ogrenciId);
        id.setKitap(kitapId);

        OgrenciKitap ok = ogrenciKitapRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OgrenciKitap bulunamadı"));

        OgrenciKitapResponse response = new OgrenciKitapResponse();
        response.setOgrenciId(ok.getOgrenci().getOgrenciID());
        response.setKitapId(ok.getKitap().getKitapID());
        response.setAlisTarihi(ok.getAlisTarihi());
        response.setIadeTarihi(ok.getIadeTarihi());
        response.setIadeDurumu(ok.isIadeDurumu());
        return response;
    }

    public OgrenciKitapResponse add(CreateOgrenciKitapRequest request) {
        Ogrenci ogrenci = ogrenciRepository.findById(request.getOgrenciId())
                .orElseThrow(() -> new RuntimeException("Ogrenci bulunamadı"));
        Kitap kitap = kitapRepository.findById(request.getKitapId())
                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı"));

        OgrenciKitap ok = new OgrenciKitap();
        ok.setOgrenci(ogrenci);
        ok.setKitap(kitap);
        ok.setAlisTarihi(request.getAlisTarihi());
        ok.setIadeTarihi(request.getIadeTarihi());
        ok.setIadeDurumu(request.isIadeDurumu());
        ogrenciKitapRepository.save(ok);

        OgrenciKitapResponse response = new OgrenciKitapResponse();
        response.setOgrenciId(ok.getOgrenci().getOgrenciID());
        response.setKitapId(ok.getKitap().getKitapID());
        response.setAlisTarihi(ok.getAlisTarihi());
        response.setIadeTarihi(ok.getIadeTarihi());
        response.setIadeDurumu(ok.isIadeDurumu());
        return response;
    }

    public OgrenciKitapResponse update(UUID ogrenciId, UUID kitapId,
                                        UpdateOgrenciKitapRequest request) {
        OgrenciKitapId id = new OgrenciKitapId();
        id.setOgrenci(ogrenciId);
        id.setKitap(kitapId);

        OgrenciKitap ok = ogrenciKitapRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OgrenciKitap bulunamadı"));

        ok.setAlisTarihi(request.getAlisTarihi());
        ok.setIadeTarihi(request.getIadeTarihi());
        ok.setIadeDurumu(request.isIadeDurumu());
        ogrenciKitapRepository.save(ok);

        OgrenciKitapResponse response = new OgrenciKitapResponse();
        response.setOgrenciId(ok.getOgrenci().getOgrenciID());
        response.setKitapId(ok.getKitap().getKitapID());
        response.setAlisTarihi(ok.getAlisTarihi());
        response.setIadeTarihi(ok.getIadeTarihi());
        response.setIadeDurumu(ok.isIadeDurumu());
        return response;
    }

    public void delete(UUID ogrenciId, UUID kitapId) {
        OgrenciKitapId id = new OgrenciKitapId();
        id.setOgrenci(ogrenciId);
        id.setKitap(kitapId);

        OgrenciKitap ok = ogrenciKitapRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OgrenciKitap bulunamadı"));
        ogrenciKitapRepository.delete(ok);
    }
}

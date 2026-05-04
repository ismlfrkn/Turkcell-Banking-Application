package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.ogrencikitap.request.OgrenciKitapCreateRequest;
import com.turkcell.libraryapp.dto.ogrencikitap.request.OgrenciKitapUpdateRequest;
import com.turkcell.libraryapp.dto.ogrencikitap.response.*;
import com.turkcell.libraryapp.entity.KutuphaneKitap;
import com.turkcell.libraryapp.entity.Ogrenci;
import com.turkcell.libraryapp.entity.OgrenciKitap;
import com.turkcell.libraryapp.repository.OgrenciKitapRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
public class OgrenciKitapServiceImpl {

    private static final double GUNLUK_CEZA = 5.0;

    private final OgrenciKitapRepository ogrenciKitapRepository;
    private final OgrenciServiceImpl ogrenciService;
    private final KutuphaneKitapServiceImpl kutuphaneKitapService;

    public OgrenciKitapServiceImpl(
            OgrenciKitapRepository ogrenciKitapRepository,
            OgrenciServiceImpl ogrenciService,
            KutuphaneKitapServiceImpl kutuphaneKitapService
    ) {
        this.ogrenciKitapRepository = ogrenciKitapRepository;
        this.ogrenciService = ogrenciService;
        this.kutuphaneKitapService = kutuphaneKitapService;
    }

    public CreatedOgrenciKitapResponse create(OgrenciKitapCreateRequest request) {

        Ogrenci ogrenci = ogrenciService.getEntityById(request.ogrenciId());
        KutuphaneKitap stok = kutuphaneKitapService.getEntityById(request.kutuphaneKitapId());

        if (ogrenciKitapRepository
                .existsByOgrenci_OgrenciIdAndKutuphaneKitap_KutuphaneKitapIdAndIadeDurumuFalse(
                        request.ogrenciId(),
                        request.kutuphaneKitapId()
                )) {
            throw new RuntimeException("Bu kitap zaten öğrencide.");
        }

        if (stok.getStokMiktar() <= 0) {
            throw new RuntimeException("Stok yok.");
        }

        stok.setStokMiktar(stok.getStokMiktar() - 1);
        kutuphaneKitapService.save(stok);

        OgrenciKitap entity = new OgrenciKitap();
        entity.setOgrenci(ogrenci);
        entity.setKutuphaneKitap(stok);

        OgrenciKitap saved = ogrenciKitapRepository.save(entity);

        return new CreatedOgrenciKitapResponse(
                saved.getOgrenciKitapId(),
                saved.getOgrenci().getOgrenciId(),
                saved.getKutuphaneKitap().getKutuphaneKitapId(),
                saved.getKutuphaneKitap().getKutuphane().getKutuphaneId(),
                saved.getKutuphaneKitap().getKitap().getKitapId(),
                saved.getAlisTarihi(),
                saved.getSonIadeTarihi(),
                saved.getIadeTarihi(),
                saved.isIadeDurumu(),
                saved.getGecikmeCezasi()
        );
    }

    public UpdatedOgrenciKitapResponse update(UUID id, OgrenciKitapUpdateRequest request) {

        OgrenciKitap entity = getEntityById(id);

        if (entity.isIadeDurumu()) {
            throw new RuntimeException("Zaten iade edilmiş.");
        }

        LocalDate today = LocalDate.now();

        entity.setIadeDurumu(true);
        entity.setIadeTarihi(today);

        if (today.isAfter(entity.getSonIadeTarihi())) {
            long gun = ChronoUnit.DAYS.between(entity.getSonIadeTarihi(), today);
            entity.setGecikmeCezasi(gun * GUNLUK_CEZA);
        }

        KutuphaneKitap stok = entity.getKutuphaneKitap();
        stok.setStokMiktar(stok.getStokMiktar() + 1);
        kutuphaneKitapService.save(stok);

        OgrenciKitap updated = ogrenciKitapRepository.save(entity);

        return new UpdatedOgrenciKitapResponse(
                updated.getOgrenciKitapId(),
                updated.getOgrenci().getOgrenciId(),
                updated.getKutuphaneKitap().getKutuphaneKitapId(),
                updated.getKutuphaneKitap().getKutuphane().getKutuphaneId(),
                updated.getKutuphaneKitap().getKitap().getKitapId(),
                updated.getAlisTarihi(),
                updated.getSonIadeTarihi(),
                updated.getIadeTarihi(),
                updated.isIadeDurumu(),
                updated.getGecikmeCezasi()
        );
    }

    public GetByIdOgrenciKitapResponse getById(UUID id) {
        OgrenciKitap item = getEntityById(id);

        return new GetByIdOgrenciKitapResponse(
                item.getOgrenciKitapId(),
                item.getOgrenci().getOgrenciId(),
                item.getOgrenci().getOgrenciAd(),
                item.getOgrenci().getEmail(),
                item.getKutuphaneKitap().getKutuphaneKitapId(),
                item.getKutuphaneKitap().getKutuphane().getKutuphaneId(),
                item.getKutuphaneKitap().getKutuphane().getKutuphaneAd(),
                item.getKutuphaneKitap().getKitap().getKitapId(),
                item.getKutuphaneKitap().getKitap().getKitapAd(),
                item.getKutuphaneKitap().getKitap().getKitapTur(),
                item.getAlisTarihi(),
                item.getSonIadeTarihi(),
                item.getIadeTarihi(),
                item.isIadeDurumu(),
                item.getGecikmeCezasi()
        );
    }

    public List<ListOgrenciKitapResponse> getAll() {
        return ogrenciKitapRepository.findAll()
                .stream()
                .map(item -> new ListOgrenciKitapResponse(
                        item.getOgrenciKitapId(),
                        item.getOgrenci().getOgrenciAd(),
                        item.getKutuphaneKitap().getKutuphane().getKutuphaneAd(),
                        item.getKutuphaneKitap().getKitap().getKitapAd(),
                        item.getAlisTarihi(),
                        item.getSonIadeTarihi(),
                        item.getIadeTarihi(),
                        item.isIadeDurumu(),
                        item.getGecikmeCezasi()
                ))
                .toList();
    }

    public void delete(UUID id) {
        OgrenciKitap item = getEntityById(id);
        ogrenciKitapRepository.delete(item);
    }

    public OgrenciKitap getEntityById(UUID id) {
        return ogrenciKitapRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kayıt bulunamadı."));
    }
}
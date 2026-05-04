package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.kutuphaneogrenci.request.KutuphaneOgrenciCreateRequest;
import com.turkcell.libraryapp.dto.kutuphaneogrenci.request.KutuphaneOgrenciUpdateRequest;
import com.turkcell.libraryapp.dto.kutuphaneogrenci.response.CreatedKutuphaneOgrenciResponse;
import com.turkcell.libraryapp.dto.kutuphaneogrenci.response.GetByIdKutuphaneOgrenciResponse;
import com.turkcell.libraryapp.dto.kutuphaneogrenci.response.ListKutuphaneOgrenciResponse;
import com.turkcell.libraryapp.dto.kutuphaneogrenci.response.UpdatedKutuphaneOgrenciResponse;
import com.turkcell.libraryapp.entity.Kutuphane;
import com.turkcell.libraryapp.entity.KutuphaneOgrenci;
import com.turkcell.libraryapp.entity.Ogrenci;
import com.turkcell.libraryapp.repository.KutuphaneOgrenciRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KutuphaneOgrenciServiceImpl {

    private final KutuphaneOgrenciRepository kutuphaneOgrenciRepository;
    private final KutuphaneServiceImpl kutuphaneService;
    private final OgrenciServiceImpl ogrenciService;

    public KutuphaneOgrenciServiceImpl(
            KutuphaneOgrenciRepository kutuphaneOgrenciRepository,
            KutuphaneServiceImpl kutuphaneService,
            OgrenciServiceImpl ogrenciService
    ) {
        this.kutuphaneOgrenciRepository = kutuphaneOgrenciRepository;
        this.kutuphaneService = kutuphaneService;
        this.ogrenciService = ogrenciService;
    }

    public CreatedKutuphaneOgrenciResponse create(KutuphaneOgrenciCreateRequest request) {
        if (kutuphaneOgrenciRepository.existsByKutuphane_KutuphaneIdAndOgrenci_OgrenciId(
                request.kutuphaneId(), request.ogrenciId())) {
            throw new RuntimeException("Bu öğrenci zaten bu kütüphaneye kayıtlı.");
        }

        if (kutuphaneOgrenciRepository.existsByKartNo(request.kartNo())) {
            throw new RuntimeException("Bu kart numarası zaten kullanılıyor.");
        }

        Kutuphane kutuphane = kutuphaneService.getEntityById(request.kutuphaneId());
        Ogrenci ogrenci = ogrenciService.getEntityById(request.ogrenciId());

        KutuphaneOgrenci kayit = new KutuphaneOgrenci();
        kayit.setKutuphane(kutuphane);
        kayit.setOgrenci(ogrenci);
        kayit.setKartNo(request.kartNo());
        kayit.setAktifMi(true);

        KutuphaneOgrenci saved = kutuphaneOgrenciRepository.save(kayit);

        return new CreatedKutuphaneOgrenciResponse(
                saved.getKutuphaneOgrenciId(),
                saved.getKutuphane().getKutuphaneId(),
                saved.getOgrenci().getOgrenciId(),
                saved.getKayitTarihi(),
                saved.getKartNo(),
                saved.isAktifMi()
        );
    }

    public UpdatedKutuphaneOgrenciResponse update(UUID id, KutuphaneOgrenciUpdateRequest request) {
        KutuphaneOgrenci kayit = getEntityById(id);

        if (!kayit.getKartNo().equals(request.kartNo()) &&
                kutuphaneOgrenciRepository.existsByKartNo(request.kartNo())) {
            throw new RuntimeException("Bu kart numarası zaten kullanılıyor.");
        }

        kayit.setKartNo(request.kartNo());
        kayit.setAktifMi(request.aktifMi());

        KutuphaneOgrenci updated = kutuphaneOgrenciRepository.save(kayit);

        return new UpdatedKutuphaneOgrenciResponse(
                updated.getKutuphaneOgrenciId(),
                updated.getKutuphane().getKutuphaneId(),
                updated.getOgrenci().getOgrenciId(),
                updated.getKayitTarihi(),
                updated.getKartNo(),
                updated.isAktifMi()
        );
    }

    public GetByIdKutuphaneOgrenciResponse getById(UUID id) {
        KutuphaneOgrenci kayit = getEntityById(id);

        return new GetByIdKutuphaneOgrenciResponse(
                kayit.getKutuphaneOgrenciId(),
                kayit.getKutuphane().getKutuphaneId(),
                kayit.getKutuphane().getKutuphaneAd(),
                kayit.getOgrenci().getOgrenciId(),
                kayit.getOgrenci().getOgrenciAd(),
                kayit.getOgrenci().getEmail(),
                kayit.getKayitTarihi(),
                kayit.getKartNo(),
                kayit.isAktifMi()
        );
    }

    public List<ListKutuphaneOgrenciResponse> getAll() {
        return kutuphaneOgrenciRepository.findAll()
                .stream()
                .map(kayit -> new ListKutuphaneOgrenciResponse(
                        kayit.getKutuphaneOgrenciId(),
                        kayit.getKutuphane().getKutuphaneAd(),
                        kayit.getOgrenci().getOgrenciAd(),
                        kayit.getKartNo(),
                        kayit.getKayitTarihi(),
                        kayit.isAktifMi()
                ))
                .toList();
    }

    public void delete(UUID id) {
        KutuphaneOgrenci kayit = getEntityById(id);
        kutuphaneOgrenciRepository.delete(kayit);
    }

    public KutuphaneOgrenci getEntityById(UUID id) {
        return kutuphaneOgrenciRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kütüphane öğrenci kaydı bulunamadı."));
    }
}
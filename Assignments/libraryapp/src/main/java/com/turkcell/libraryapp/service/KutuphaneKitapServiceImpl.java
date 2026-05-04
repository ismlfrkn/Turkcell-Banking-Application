package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.kutuphanekitap.request.KutuphaneKitapCreateRequest;
import com.turkcell.libraryapp.dto.kutuphanekitap.request.KutuphaneKitapUpdateRequest;
import com.turkcell.libraryapp.dto.kutuphanekitap.response.CreatedKutuphaneKitapResponse;
import com.turkcell.libraryapp.dto.kutuphanekitap.response.GetByIdKutuphaneKitapResponse;
import com.turkcell.libraryapp.dto.kutuphanekitap.response.ListKutuphaneKitapResponse;
import com.turkcell.libraryapp.dto.kutuphanekitap.response.UpdatedKutuphaneKitapResponse;
import com.turkcell.libraryapp.entity.Kitap;
import com.turkcell.libraryapp.entity.Kutuphane;
import com.turkcell.libraryapp.entity.KutuphaneKitap;
import com.turkcell.libraryapp.repository.KutuphaneKitapRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KutuphaneKitapServiceImpl {

        private final KutuphaneKitapRepository kutuphaneKitapRepository;
        private final KutuphaneServiceImpl kutuphaneService;
        private final KitapServiceImpl kitapService;

        public KutuphaneKitapServiceImpl(
                        KutuphaneKitapRepository kutuphaneKitapRepository,
                        KutuphaneServiceImpl kutuphaneService,
                        KitapServiceImpl kitapService) {
                this.kutuphaneKitapRepository = kutuphaneKitapRepository;
                this.kutuphaneService = kutuphaneService;
                this.kitapService = kitapService;
        }

        public CreatedKutuphaneKitapResponse create(KutuphaneKitapCreateRequest request) {
                if (kutuphaneKitapRepository.existsByKutuphane_KutuphaneIdAndKitap_KitapId(
                                request.kutuphaneId(), request.kitapId())) {
                        throw new RuntimeException("Bu kitap zaten bu kütüphaneye eklenmiş.");
                }

                Kutuphane kutuphane = kutuphaneService.getEntityById(request.kutuphaneId());
                Kitap kitap = kitapService.getKitapEntityById(request.kitapId());

                KutuphaneKitap kutuphaneKitap = new KutuphaneKitap();
                kutuphaneKitap.setKutuphane(kutuphane);
                kutuphaneKitap.setKitap(kitap);
                kutuphaneKitap.setStokMiktar(request.stokMiktar());

                KutuphaneKitap saved = kutuphaneKitapRepository.save(kutuphaneKitap);

                return new CreatedKutuphaneKitapResponse(
                                saved.getKutuphaneKitapId(),
                                saved.getKutuphane().getKutuphaneId(),
                                saved.getKitap().getKitapId(),
                                saved.getStokMiktar(),
                                saved.getEklemeTarihi());
        }

        public UpdatedKutuphaneKitapResponse update(UUID id, KutuphaneKitapUpdateRequest request) {
                KutuphaneKitap kutuphaneKitap = getEntityById(id);

                kutuphaneKitap.setStokMiktar(request.stokMiktar());

                KutuphaneKitap updated = kutuphaneKitapRepository.save(kutuphaneKitap);

                return new UpdatedKutuphaneKitapResponse(
                                updated.getKutuphaneKitapId(),
                                updated.getKutuphane().getKutuphaneId(),
                                updated.getKitap().getKitapId(),
                                updated.getStokMiktar(),
                                updated.getEklemeTarihi());
        }

        public GetByIdKutuphaneKitapResponse getById(UUID id) {
                KutuphaneKitap item = getEntityById(id);

                return new GetByIdKutuphaneKitapResponse(
                                item.getKutuphaneKitapId(),
                                item.getKutuphane().getKutuphaneId(),
                                item.getKutuphane().getKutuphaneAd(),
                                item.getKitap().getKitapId(),
                                item.getKitap().getKitapAd(),
                                item.getKitap().getKitapTur(),
                                item.getStokMiktar(),
                                item.getEklemeTarihi());
        }

        public List<ListKutuphaneKitapResponse> getAll() {
                return kutuphaneKitapRepository.findAll()
                                .stream()
                                .map(item -> new ListKutuphaneKitapResponse(
                                                item.getKutuphaneKitapId(),
                                                item.getKutuphane().getKutuphaneAd(),
                                                item.getKitap().getKitapAd(),
                                                item.getStokMiktar(),
                                                item.getEklemeTarihi()))
                                .toList();
        }

        public void delete(UUID id) {
                KutuphaneKitap item = getEntityById(id);
                kutuphaneKitapRepository.delete(item);
        }

        public KutuphaneKitap getEntityById(UUID id) {
                return kutuphaneKitapRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Kütüphane kitap kaydı bulunamadı."));
        }

        public KutuphaneKitap save(KutuphaneKitap kutuphaneKitap) {
                return kutuphaneKitapRepository.save(kutuphaneKitap);
        }
}
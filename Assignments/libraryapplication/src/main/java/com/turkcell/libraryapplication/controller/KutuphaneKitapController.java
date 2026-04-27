package com.turkcell.libraryapplication.controller;

import com.turkcell.libraryapplication.dto.request.CreateKutuphaneKitapRequest;
import com.turkcell.libraryapplication.dto.request.UpdateKutuphaneKitapRequest;
import com.turkcell.libraryapplication.dto.response.KutuphaneKitapResponse;
import com.turkcell.libraryapplication.service.KutuphaneKitapServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/kutuphane-kitap")
public class KutuphaneKitapController {

    private final KutuphaneKitapServiceImpl kutuphaneKitapService;

    public KutuphaneKitapController(KutuphaneKitapServiceImpl kutuphaneKitapService) {
        this.kutuphaneKitapService = kutuphaneKitapService;
    }

    @GetMapping
    public ResponseEntity<List<KutuphaneKitapResponse>> getAll() {
        return ResponseEntity.ok(kutuphaneKitapService.getAll());
    }

    @GetMapping("/{kutuphaneId}/{kitapId}")
    public ResponseEntity<KutuphaneKitapResponse> getById(@PathVariable UUID kutuphaneId,
                                                            @PathVariable UUID kitapId) {
        return ResponseEntity.ok(kutuphaneKitapService.getById(kutuphaneId, kitapId));
    }

    @PostMapping
    public ResponseEntity<KutuphaneKitapResponse> add(@RequestBody CreateKutuphaneKitapRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(kutuphaneKitapService.add(request));
    }

    @PutMapping("/{kutuphaneId}/{kitapId}")
    public ResponseEntity<KutuphaneKitapResponse> update(@PathVariable UUID kutuphaneId,
                                                           @PathVariable UUID kitapId,
                                                           @RequestBody UpdateKutuphaneKitapRequest request) {
        return ResponseEntity.ok(kutuphaneKitapService.update(kutuphaneId, kitapId, request));
    }

    @DeleteMapping("/{kutuphaneId}/{kitapId}")
    public ResponseEntity<Void> delete(@PathVariable UUID kutuphaneId,
                                        @PathVariable UUID kitapId) {
        kutuphaneKitapService.delete(kutuphaneId, kitapId);
        return ResponseEntity.noContent().build();
    }
}

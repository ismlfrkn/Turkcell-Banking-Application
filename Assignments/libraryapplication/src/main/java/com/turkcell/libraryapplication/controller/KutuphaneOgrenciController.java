package com.turkcell.libraryapplication.controller;

import com.turkcell.libraryapplication.dto.request.CreateKutuphaneOgrenciRequest;
import com.turkcell.libraryapplication.dto.request.UpdateKutuphaneOgrenciRequest;
import com.turkcell.libraryapplication.dto.response.KutuphaneOgrenciResponse;
import com.turkcell.libraryapplication.service.KutuphaneOgrenciServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/kutuphane-ogrenci")
public class KutuphaneOgrenciController {

    private final KutuphaneOgrenciServiceImpl kutuphaneOgrenciService;

    public KutuphaneOgrenciController(KutuphaneOgrenciServiceImpl kutuphaneOgrenciService) {
        this.kutuphaneOgrenciService = kutuphaneOgrenciService;
    }

    @GetMapping
    public ResponseEntity<List<KutuphaneOgrenciResponse>> getAll() {
        return ResponseEntity.ok(kutuphaneOgrenciService.getAll());
    }

    @GetMapping("/{ogrenciId}/{kutuphaneId}")
    public ResponseEntity<KutuphaneOgrenciResponse> getById(@PathVariable UUID ogrenciId,
                                                              @PathVariable UUID kutuphaneId) {
        return ResponseEntity.ok(kutuphaneOgrenciService.getById(ogrenciId, kutuphaneId));
    }

    @PostMapping
    public ResponseEntity<KutuphaneOgrenciResponse> add(@RequestBody CreateKutuphaneOgrenciRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(kutuphaneOgrenciService.add(request));
    }

    @PutMapping("/{ogrenciId}/{kutuphaneId}")
    public ResponseEntity<KutuphaneOgrenciResponse> update(@PathVariable UUID ogrenciId,
                                                             @PathVariable UUID kutuphaneId,
                                                             @RequestBody UpdateKutuphaneOgrenciRequest request) {
        return ResponseEntity.ok(kutuphaneOgrenciService.update(ogrenciId, kutuphaneId, request));
    }

    @DeleteMapping("/{ogrenciId}/{kutuphaneId}")
    public ResponseEntity<Void> delete(@PathVariable UUID ogrenciId,
                                        @PathVariable UUID kutuphaneId) {
        kutuphaneOgrenciService.delete(ogrenciId, kutuphaneId);
        return ResponseEntity.noContent().build();
    }
}

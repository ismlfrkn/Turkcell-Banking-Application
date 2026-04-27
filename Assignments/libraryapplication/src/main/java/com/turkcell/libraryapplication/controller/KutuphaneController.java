package com.turkcell.libraryapplication.controller;

import com.turkcell.libraryapplication.dto.request.CreateKutuphaneRequest;
import com.turkcell.libraryapplication.dto.request.UpdateKutuphaneRequest;
import com.turkcell.libraryapplication.dto.response.KutuphaneResponse;
import com.turkcell.libraryapplication.service.KutuphaneServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/kutuphaneler")
public class KutuphaneController {

    private final KutuphaneServiceImpl kutuphaneService;

    public KutuphaneController(KutuphaneServiceImpl kutuphaneService) {
        this.kutuphaneService = kutuphaneService;
    }

    @GetMapping
    public ResponseEntity<List<KutuphaneResponse>> getAll() {
        return ResponseEntity.ok(kutuphaneService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<KutuphaneResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(kutuphaneService.getById(id));
    }

    @PostMapping
    public ResponseEntity<KutuphaneResponse> add(@RequestBody CreateKutuphaneRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(kutuphaneService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<KutuphaneResponse> update(@PathVariable UUID id,
                                                      @RequestBody UpdateKutuphaneRequest request) {
        return ResponseEntity.ok(kutuphaneService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        kutuphaneService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

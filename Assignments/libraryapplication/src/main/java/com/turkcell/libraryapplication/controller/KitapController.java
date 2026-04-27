package com.turkcell.libraryapplication.controller;

import com.turkcell.libraryapplication.dto.request.CreateKitapRequest;
import com.turkcell.libraryapplication.dto.request.UpdateKitapRequest;
import com.turkcell.libraryapplication.dto.response.KitapResponse;
import com.turkcell.libraryapplication.service.KitapServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/kitaplar")
public class KitapController {

    private final KitapServiceImpl kitapService;

    public KitapController(KitapServiceImpl kitapService) {
        this.kitapService = kitapService;
    }

    @GetMapping
    public ResponseEntity<List<KitapResponse>> getAll() {
        return ResponseEntity.ok(kitapService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<KitapResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(kitapService.getById(id));
    }

    @PostMapping
    public ResponseEntity<KitapResponse> add(@RequestBody CreateKitapRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(kitapService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<KitapResponse> update(@PathVariable UUID id,
                                                  @RequestBody UpdateKitapRequest request) {
        return ResponseEntity.ok(kitapService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        kitapService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

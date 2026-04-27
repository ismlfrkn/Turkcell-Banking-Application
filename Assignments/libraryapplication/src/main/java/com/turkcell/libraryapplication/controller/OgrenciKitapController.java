package com.turkcell.libraryapplication.controller;

import com.turkcell.libraryapplication.dto.request.CreateOgrenciKitapRequest;
import com.turkcell.libraryapplication.dto.request.UpdateOgrenciKitapRequest;
import com.turkcell.libraryapplication.dto.response.OgrenciKitapResponse;
import com.turkcell.libraryapplication.service.OgrenciKitapServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/ogrenci-kitap")
public class OgrenciKitapController {

    private final OgrenciKitapServiceImpl ogrenciKitapService;

    public OgrenciKitapController(OgrenciKitapServiceImpl ogrenciKitapService) {
        this.ogrenciKitapService = ogrenciKitapService;
    }

    @GetMapping
    public ResponseEntity<List<OgrenciKitapResponse>> getAll() {
        return ResponseEntity.ok(ogrenciKitapService.getAll());
    }

    @GetMapping("/{ogrenciId}/{kitapId}")
    public ResponseEntity<OgrenciKitapResponse> getById(@PathVariable UUID ogrenciId,
                                                          @PathVariable UUID kitapId) {
        return ResponseEntity.ok(ogrenciKitapService.getById(ogrenciId, kitapId));
    }

    @PostMapping
    public ResponseEntity<OgrenciKitapResponse> add(@RequestBody CreateOgrenciKitapRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ogrenciKitapService.add(request));
    }

    @PutMapping("/{ogrenciId}/{kitapId}")
    public ResponseEntity<OgrenciKitapResponse> update(@PathVariable UUID ogrenciId,
                                                         @PathVariable UUID kitapId,
                                                         @RequestBody UpdateOgrenciKitapRequest request) {
        return ResponseEntity.ok(ogrenciKitapService.update(ogrenciId, kitapId, request));
    }

    @DeleteMapping("/{ogrenciId}/{kitapId}")
    public ResponseEntity<Void> delete(@PathVariable UUID ogrenciId,
                                        @PathVariable UUID kitapId) {
        ogrenciKitapService.delete(ogrenciId, kitapId);
        return ResponseEntity.noContent().build();
    }
}

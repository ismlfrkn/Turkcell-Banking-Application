package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.ogrencikitap.request.OgrenciKitapCreateRequest;
import com.turkcell.libraryapp.dto.ogrencikitap.request.OgrenciKitapUpdateRequest;
import com.turkcell.libraryapp.dto.ogrencikitap.response.*;
import com.turkcell.libraryapp.service.OgrenciKitapServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/ogrenci-kitaplar")
public class OgrenciKitapController {

    private final OgrenciKitapServiceImpl service;

    public OgrenciKitapController(OgrenciKitapServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public CreatedOgrenciKitapResponse create(@Valid @RequestBody OgrenciKitapCreateRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public UpdatedOgrenciKitapResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody OgrenciKitapUpdateRequest request
    ) {
        return service.update(id, request);
    }

    @GetMapping("/{id}")
    public GetByIdOgrenciKitapResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ListOgrenciKitapResponse> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
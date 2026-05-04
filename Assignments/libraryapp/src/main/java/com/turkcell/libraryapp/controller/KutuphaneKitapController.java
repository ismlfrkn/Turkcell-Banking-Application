package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.kutuphanekitap.request.KutuphaneKitapCreateRequest;
import com.turkcell.libraryapp.dto.kutuphanekitap.request.KutuphaneKitapUpdateRequest;
import com.turkcell.libraryapp.dto.kutuphanekitap.response.CreatedKutuphaneKitapResponse;
import com.turkcell.libraryapp.dto.kutuphanekitap.response.GetByIdKutuphaneKitapResponse;
import com.turkcell.libraryapp.dto.kutuphanekitap.response.ListKutuphaneKitapResponse;
import com.turkcell.libraryapp.dto.kutuphanekitap.response.UpdatedKutuphaneKitapResponse;
import com.turkcell.libraryapp.service.KutuphaneKitapServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/kutuphane-kitaplar")
public class KutuphaneKitapController {

    private final KutuphaneKitapServiceImpl service;

    public KutuphaneKitapController(KutuphaneKitapServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public CreatedKutuphaneKitapResponse create(@Valid @RequestBody KutuphaneKitapCreateRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public UpdatedKutuphaneKitapResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody KutuphaneKitapUpdateRequest request
    ) {
        return service.update(id, request);
    }

    @GetMapping("/{id}")
    public GetByIdKutuphaneKitapResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ListKutuphaneKitapResponse> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
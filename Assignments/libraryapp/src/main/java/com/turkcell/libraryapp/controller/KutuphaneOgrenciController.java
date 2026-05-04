package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.kutuphaneogrenci.request.KutuphaneOgrenciCreateRequest;
import com.turkcell.libraryapp.dto.kutuphaneogrenci.request.KutuphaneOgrenciUpdateRequest;
import com.turkcell.libraryapp.dto.kutuphaneogrenci.response.CreatedKutuphaneOgrenciResponse;
import com.turkcell.libraryapp.dto.kutuphaneogrenci.response.GetByIdKutuphaneOgrenciResponse;
import com.turkcell.libraryapp.dto.kutuphaneogrenci.response.ListKutuphaneOgrenciResponse;
import com.turkcell.libraryapp.dto.kutuphaneogrenci.response.UpdatedKutuphaneOgrenciResponse;
import com.turkcell.libraryapp.service.KutuphaneOgrenciServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/kutuphane-ogrenciler")
public class KutuphaneOgrenciController {

    private final KutuphaneOgrenciServiceImpl service;

    public KutuphaneOgrenciController(KutuphaneOgrenciServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public CreatedKutuphaneOgrenciResponse create(@Valid @RequestBody KutuphaneOgrenciCreateRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public UpdatedKutuphaneOgrenciResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody KutuphaneOgrenciUpdateRequest request
    ) {
        return service.update(id, request);
    }

    @GetMapping("/{id}")
    public GetByIdKutuphaneOgrenciResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ListKutuphaneOgrenciResponse> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.kutuphane.request.KutuphaneCreateRequest;
import com.turkcell.libraryapp.dto.kutuphane.request.KutuphaneUpdateRequest;
import com.turkcell.libraryapp.dto.kutuphane.response.CreatedKutuphaneResponse;
import com.turkcell.libraryapp.dto.kutuphane.response.GetByIdKutuphaneResponse;
import com.turkcell.libraryapp.dto.kutuphane.response.ListKutuphaneResponse;
import com.turkcell.libraryapp.dto.kutuphane.response.UpdatedKutuphaneResponse;
import com.turkcell.libraryapp.service.KutuphaneServiceImpl;
import jakarta.validation.Valid;
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

    @PostMapping
    public CreatedKutuphaneResponse create(@Valid @RequestBody KutuphaneCreateRequest request) {
        return kutuphaneService.create(request);
    }

    @PutMapping("/{id}")
    public UpdatedKutuphaneResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody KutuphaneUpdateRequest request
    ) {
        return kutuphaneService.update(id, request);
    }

    @GetMapping("/{id}")
    public GetByIdKutuphaneResponse getById(@PathVariable UUID id) {
        return kutuphaneService.getById(id);
    }

    @GetMapping
    public List<ListKutuphaneResponse> getAll() {
        return kutuphaneService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        kutuphaneService.delete(id);
    }
}
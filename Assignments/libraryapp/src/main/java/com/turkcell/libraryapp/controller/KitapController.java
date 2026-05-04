package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.kitap.request.KitapCreateRequest;
import com.turkcell.libraryapp.dto.kitap.request.KitapUpdateRequest;
import com.turkcell.libraryapp.dto.kitap.response.CreatedKitapResponse;
import com.turkcell.libraryapp.dto.kitap.response.GetByIdKitapResponse;
import com.turkcell.libraryapp.dto.kitap.response.ListKitapResponse;
import com.turkcell.libraryapp.dto.kitap.response.UpdatedKitapResponse;
import com.turkcell.libraryapp.service.KitapServiceImpl;
import jakarta.validation.Valid;
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

    @PostMapping
    public CreatedKitapResponse create(@Valid @RequestBody KitapCreateRequest request) {
        return kitapService.create(request);
    }

    @PutMapping("/{id}")
    public UpdatedKitapResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody KitapUpdateRequest request
    ) {
        return kitapService.update(id, request);
    }

    @GetMapping("/{id}")
    public GetByIdKitapResponse getById(@PathVariable UUID id) {
        return kitapService.getById(id);
    }

    @GetMapping
    public List<ListKitapResponse> getAll() {
        return kitapService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        kitapService.delete(id);
    }
}
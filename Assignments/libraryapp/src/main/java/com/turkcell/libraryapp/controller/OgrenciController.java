package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.ogrenci.request.OgrenciCreateRequest;
import com.turkcell.libraryapp.dto.ogrenci.request.OgrenciUpdateRequest;
import com.turkcell.libraryapp.dto.ogrenci.response.CreatedOgrenciResponse;
import com.turkcell.libraryapp.dto.ogrenci.response.GetByIdOgrenciResponse;
import com.turkcell.libraryapp.dto.ogrenci.response.ListOgrenciResponse;
import com.turkcell.libraryapp.dto.ogrenci.response.UpdatedOgrenciResponse;
import com.turkcell.libraryapp.service.OgrenciServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/ogrenciler")
public class OgrenciController {

    private final OgrenciServiceImpl ogrenciService;

    public OgrenciController(OgrenciServiceImpl ogrenciService) {
        this.ogrenciService = ogrenciService;
    }

    @PostMapping
    public CreatedOgrenciResponse create(@Valid @RequestBody OgrenciCreateRequest request) {
        return ogrenciService.create(request);
    }

    @PutMapping("/{id}")
    public UpdatedOgrenciResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody OgrenciUpdateRequest request
    ) {
        return ogrenciService.update(id, request);
    }

    @GetMapping("/{id}")
    public GetByIdOgrenciResponse getById(@PathVariable UUID id) {
        return ogrenciService.getById(id);
    }

    @GetMapping
    public List<ListOgrenciResponse> getAll() {
        return ogrenciService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        ogrenciService.delete(id);
    }
}
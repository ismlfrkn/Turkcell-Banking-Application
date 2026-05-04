package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.yazar.request.YazarCreateRequest;
import com.turkcell.libraryapp.dto.yazar.request.YazarUpdateRequest;
import com.turkcell.libraryapp.dto.yazar.response.CreatedYazarResponse;
import com.turkcell.libraryapp.dto.yazar.response.GetByIdYazarResponse;
import com.turkcell.libraryapp.dto.yazar.response.ListYazarResponse;
import com.turkcell.libraryapp.dto.yazar.response.UpdatedYazarResponse;
import com.turkcell.libraryapp.service.YazarServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/yazarlar")
public class YazarController {

    private final YazarServiceImpl yazarService;

    public YazarController(YazarServiceImpl yazarService) {
        this.yazarService = yazarService;
    }

    @PostMapping
    public CreatedYazarResponse create(@Valid @RequestBody YazarCreateRequest request) {
        return yazarService.create(request);
    }

    @PutMapping("/{id}")
    public UpdatedYazarResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody YazarUpdateRequest request
    ) {
        return yazarService.update(id, request);
    }

    @GetMapping("/{id}")
    public GetByIdYazarResponse getById(@PathVariable UUID id) {
        return yazarService.getById(id);
    }

    @GetMapping
    public List<ListYazarResponse> getAll() {
        return yazarService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        yazarService.delete(id);
    }
}
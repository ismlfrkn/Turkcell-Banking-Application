package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.hademe.request.HademeCreateRequest;
import com.turkcell.libraryapp.dto.hademe.request.HademeUpdateRequest;
import com.turkcell.libraryapp.dto.hademe.response.CreatedHademeResponse;
import com.turkcell.libraryapp.dto.hademe.response.GetByIdHademeResponse;
import com.turkcell.libraryapp.dto.hademe.response.ListHademeResponse;
import com.turkcell.libraryapp.dto.hademe.response.UpdatedHademeResponse;
import com.turkcell.libraryapp.service.HademeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/hademeler")
public class HademeController {

    private final HademeServiceImpl hademeService;

    public HademeController(HademeServiceImpl hademeService) {
        this.hademeService = hademeService;
    }

    @PostMapping
    public CreatedHademeResponse create(@Valid @RequestBody HademeCreateRequest request) {
        return hademeService.create(request);
    }

    @PutMapping("/{id}")
    public UpdatedHademeResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody HademeUpdateRequest request
    ) {
        return hademeService.update(id, request);
    }

    @GetMapping("/{id}")
    public GetByIdHademeResponse getById(@PathVariable UUID id) {
        return hademeService.getById(id);
    }

    @GetMapping
    public List<ListHademeResponse> getAll() {
        return hademeService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        hademeService.delete(id);
    }
}
package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.yayinevi.request.YayineviCreateRequest;
import com.turkcell.libraryapp.dto.yayinevi.request.YayineviUpdateRequest;
import com.turkcell.libraryapp.dto.yayinevi.response.CreatedYayineviResponse;
import com.turkcell.libraryapp.dto.yayinevi.response.GetByIdYayineviResponse;
import com.turkcell.libraryapp.dto.yayinevi.response.ListYayineviResponse;
import com.turkcell.libraryapp.dto.yayinevi.response.UpdatedYayineviResponse;
import com.turkcell.libraryapp.service.YayineviServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/yayinevleri")
public class YayineviController {

    private final YayineviServiceImpl yayineviService;

    public YayineviController(YayineviServiceImpl yayineviService) {
        this.yayineviService = yayineviService;
    }

    @PostMapping
    public CreatedYayineviResponse create(@Valid @RequestBody YayineviCreateRequest request) {
        return yayineviService.create(request);
    }

    @PutMapping("/{id}")
    public UpdatedYayineviResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody YayineviUpdateRequest request
    ) {
        return yayineviService.update(id, request);
    }

    @GetMapping("/{id}")
    public GetByIdYayineviResponse getById(@PathVariable UUID id) {
        return yayineviService.getById(id);
    }

    @GetMapping
    public List<ListYayineviResponse> getAll() {
        return yayineviService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        yayineviService.delete(id);
    }
}
package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.kutuphanesorumlusu.request.KutuphaneSorumlusuCreateRequest;
import com.turkcell.libraryapp.entity.KutuphaneSorumlusu;
import com.turkcell.libraryapp.service.KutuphaneSorumlusuServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sorumlular")
public class KutuphaneSorumlusuController {

    private final KutuphaneSorumlusuServiceImpl service;

    public KutuphaneSorumlusuController(KutuphaneSorumlusuServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public KutuphaneSorumlusu create(@Valid @RequestBody KutuphaneSorumlusuCreateRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<KutuphaneSorumlusu> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public KutuphaneSorumlusu getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
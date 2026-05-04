package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.mudur.request.MudurCreateRequest;
import com.turkcell.libraryapp.entity.Mudur;
import com.turkcell.libraryapp.service.MudurServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/mudurler")
public class MudurController {

    private final MudurServiceImpl mudurService;

    public MudurController(MudurServiceImpl mudurService) {
        this.mudurService = mudurService;
    }

    @PostMapping
    public Mudur create(@Valid @RequestBody MudurCreateRequest request) {
        return mudurService.create(request);
    }

    @GetMapping
    public List<Mudur> getAll() {
        return mudurService.getAll();
    }

    @GetMapping("/{id}")
    public Mudur getById(@PathVariable UUID id) {
        return mudurService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        mudurService.delete(id);
    }
}
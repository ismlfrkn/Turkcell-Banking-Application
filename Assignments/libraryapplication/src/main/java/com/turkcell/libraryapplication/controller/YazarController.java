package com.turkcell.libraryapplication.controller;

import com.turkcell.libraryapplication.dto.request.CreateYazarRequest;
import com.turkcell.libraryapplication.dto.request.UpdateYazarRequest;
import com.turkcell.libraryapplication.dto.response.YazarResponse;
import com.turkcell.libraryapplication.service.YazarServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public ResponseEntity<List<YazarResponse>> getAll() {
        return ResponseEntity.ok(yazarService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<YazarResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(yazarService.getById(id));
    }

    @PostMapping
    public ResponseEntity<YazarResponse> add(@RequestBody CreateYazarRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(yazarService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<YazarResponse> update(@PathVariable UUID id,
                                                  @RequestBody UpdateYazarRequest request) {
        return ResponseEntity.ok(yazarService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        yazarService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

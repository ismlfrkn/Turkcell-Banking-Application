package com.turkcell.libraryapplication.controller;

import com.turkcell.libraryapplication.dto.request.CreateOgrenciRequest;
import com.turkcell.libraryapplication.dto.request.UpdateOgrenciRequest;
import com.turkcell.libraryapplication.dto.response.OgrenciResponse;
import com.turkcell.libraryapplication.service.OgrenciServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public ResponseEntity<List<OgrenciResponse>> getAll() {
        return ResponseEntity.ok(ogrenciService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OgrenciResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(ogrenciService.getById(id));
    }

    @PostMapping
    public ResponseEntity<OgrenciResponse> add(@RequestBody CreateOgrenciRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ogrenciService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OgrenciResponse> update(@PathVariable UUID id,
                                                    @RequestBody UpdateOgrenciRequest request) {
        return ResponseEntity.ok(ogrenciService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        ogrenciService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

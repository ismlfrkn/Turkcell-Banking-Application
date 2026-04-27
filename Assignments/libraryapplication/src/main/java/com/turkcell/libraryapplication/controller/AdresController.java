package com.turkcell.libraryapplication.controller;

import com.turkcell.libraryapplication.dto.request.CreateAdresRequest;
import com.turkcell.libraryapplication.dto.request.UpdateAdresRequest;
import com.turkcell.libraryapplication.dto.response.AdresResponse;
import com.turkcell.libraryapplication.service.AdresServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adresler")
public class AdresController {

    private final AdresServiceImpl adresService;

    public AdresController(AdresServiceImpl adresService) {
        this.adresService = adresService;
    }

    @GetMapping
    public ResponseEntity<List<AdresResponse>> getAll() {
        return ResponseEntity.ok(adresService.getAll());
    }

    @GetMapping("/{ilKodu}")
    public ResponseEntity<AdresResponse> getById(@PathVariable int ilKodu) {
        return ResponseEntity.ok(adresService.getById(ilKodu));
    }

    @PostMapping
    public ResponseEntity<AdresResponse> add(@RequestBody CreateAdresRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adresService.add(request));
    }

    @PutMapping("/{ilKodu}")
    public ResponseEntity<AdresResponse> update(@PathVariable int ilKodu,
                                                 @RequestBody UpdateAdresRequest request) {
        return ResponseEntity.ok(adresService.update(ilKodu, request));
    }

    @DeleteMapping("/{ilKodu}")
    public ResponseEntity<Void> delete(@PathVariable int ilKodu) {
        adresService.delete(ilKodu);
        return ResponseEntity.noContent().build();
    }
}
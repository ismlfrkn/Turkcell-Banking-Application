package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.adres.request.AdresCreateRequest;
import com.turkcell.libraryapp.dto.adres.request.AdresUpdateRequest;
import com.turkcell.libraryapp.dto.adres.response.CreatedAdresResponse;
import com.turkcell.libraryapp.dto.adres.response.GetByIdAdresResponse;
import com.turkcell.libraryapp.dto.adres.response.ListAdresResponse;
import com.turkcell.libraryapp.dto.adres.response.UpdatedAdresResponse;
import com.turkcell.libraryapp.service.AdresServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adresler")
public class AdresController {

    private final AdresServiceImpl adresService;

    public AdresController(AdresServiceImpl adresService) {
        this.adresService = adresService;
    }

    @PostMapping
    public CreatedAdresResponse create(@Valid @RequestBody AdresCreateRequest request) {
        return adresService.create(request);
    }

    @PutMapping("/{ilKodu}")
    public UpdatedAdresResponse update(
            @PathVariable int ilKodu,
            @Valid @RequestBody AdresUpdateRequest request
    ) {
        return adresService.update(ilKodu, request);
    }

    @GetMapping("/{ilKodu}")
    public GetByIdAdresResponse getById(@PathVariable int ilKodu) {
        return adresService.getById(ilKodu);
    }

    @GetMapping
    public List<ListAdresResponse> getAll() {
        return adresService.getAll();
    }

    @DeleteMapping("/{ilKodu}")
    public void delete(@PathVariable int ilKodu) {
        adresService.delete(ilKodu);
    }
}
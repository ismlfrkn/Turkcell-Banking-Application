package com.turkcell.libraryapplication.controller;

import com.turkcell.libraryapplication.dto.request.CreatePersonelRequest;
import com.turkcell.libraryapplication.dto.request.UpdatePersonelRequest;
import com.turkcell.libraryapplication.dto.response.PersonelResponse;
import com.turkcell.libraryapplication.service.PersonelServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/personel")
public class PersonelController {

    private final PersonelServiceImpl personelService;

    public PersonelController(PersonelServiceImpl personelService) {
        this.personelService = personelService;
    }

    @GetMapping
    public ResponseEntity<List<PersonelResponse>> getAll() {
        return ResponseEntity.ok(personelService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonelResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(personelService.getById(id));
    }

    @PostMapping
    public ResponseEntity<PersonelResponse> add(@RequestBody CreatePersonelRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personelService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonelResponse> update(@PathVariable UUID id,
                                                     @RequestBody UpdatePersonelRequest request) {
        return ResponseEntity.ok(personelService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        personelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package com.turkcell.libraryapplication.controller;

import com.turkcell.libraryapplication.dto.request.CreateYayineviRequest;
import com.turkcell.libraryapplication.dto.request.UpdateYayineviRequest;
import com.turkcell.libraryapplication.dto.response.YayineviResponse;
import com.turkcell.libraryapplication.service.YayineviServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public ResponseEntity<List<YayineviResponse>> getAll() {
        return ResponseEntity.ok(yayineviService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<YayineviResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(yayineviService.getById(id));
    }

    @PostMapping
    public ResponseEntity<YayineviResponse> add(@RequestBody CreateYayineviRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(yayineviService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<YayineviResponse> update(@PathVariable UUID id,
                                                     @RequestBody UpdateYayineviRequest request) {
        return ResponseEntity.ok(yayineviService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        yayineviService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

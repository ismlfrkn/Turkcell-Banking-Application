package com.turkcell.libraryapp_cqrs.web.controller;

import com.turkcell.libraryapp_cqrs.application.features.ogrenci.command.create.CreateOgrenciCommand;
import com.turkcell.libraryapp_cqrs.application.features.ogrenci.command.create.CreatedOgrenciResponse;
import com.turkcell.libraryapp_cqrs.core.mediator.Mediator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ogrenciler")
public class OgrencilerController {

    private final Mediator mediator;

    public OgrencilerController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public CreatedOgrenciResponse create(@RequestBody CreateOgrenciCommand command) {
        return mediator.send(command);
    }
}
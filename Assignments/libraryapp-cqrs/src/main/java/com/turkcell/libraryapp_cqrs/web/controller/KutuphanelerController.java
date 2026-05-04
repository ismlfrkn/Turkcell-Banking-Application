package com.turkcell.libraryapp_cqrs.web.controller;

import com.turkcell.libraryapp_cqrs.application.features.kutuphane.command.create.CreateKutuphaneCommand;
import com.turkcell.libraryapp_cqrs.application.features.kutuphane.command.create.CreatedKutuphaneResponse;
import com.turkcell.libraryapp_cqrs.core.mediator.Mediator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kutuphaneler")
public class KutuphanelerController {

    private final Mediator mediator;

    public KutuphanelerController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public CreatedKutuphaneResponse create(@RequestBody CreateKutuphaneCommand command) {
        return mediator.send(command);
    }
}
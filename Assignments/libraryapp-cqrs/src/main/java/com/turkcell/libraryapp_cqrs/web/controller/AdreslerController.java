package com.turkcell.libraryapp_cqrs.web.controller;

import com.turkcell.libraryapp_cqrs.application.features.adres.command.create.CreateAdresCommand;
import com.turkcell.libraryapp_cqrs.application.features.adres.command.create.CreatedAdresResponse;
import com.turkcell.libraryapp_cqrs.core.mediator.Mediator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/adresler")
public class AdreslerController {

    private final Mediator mediator;

    public AdreslerController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public CreatedAdresResponse create(@RequestBody CreateAdresCommand command) {
        return mediator.send(command);
    }
}
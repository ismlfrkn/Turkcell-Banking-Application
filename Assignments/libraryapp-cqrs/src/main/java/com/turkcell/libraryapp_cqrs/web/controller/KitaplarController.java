package com.turkcell.libraryapp_cqrs.web.controller;

import com.turkcell.libraryapp_cqrs.application.features.kitap.command.create.CreateKitapCommand;
import com.turkcell.libraryapp_cqrs.application.features.kitap.command.create.CreatedKitapResponse;
import com.turkcell.libraryapp_cqrs.core.mediator.Mediator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kitaplar")
public class KitaplarController {

    private final Mediator mediator;

    public KitaplarController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public CreatedKitapResponse create(@RequestBody CreateKitapCommand command) {
        return mediator.send(command);
    }
}
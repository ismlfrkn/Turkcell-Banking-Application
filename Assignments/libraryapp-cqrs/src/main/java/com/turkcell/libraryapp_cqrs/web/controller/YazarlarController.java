package com.turkcell.libraryapp_cqrs.web.controller;

import com.turkcell.libraryapp_cqrs.application.features.yazar.command.create.CreateYazarCommand;
import com.turkcell.libraryapp_cqrs.application.features.yazar.command.create.CreatedYazarResponse;
import com.turkcell.libraryapp_cqrs.core.mediator.Mediator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/yazarlar")
public class YazarlarController {

    private final Mediator mediator;

    public YazarlarController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public CreatedYazarResponse create(@RequestBody CreateYazarCommand command) {
        return mediator.send(command);
    }
}
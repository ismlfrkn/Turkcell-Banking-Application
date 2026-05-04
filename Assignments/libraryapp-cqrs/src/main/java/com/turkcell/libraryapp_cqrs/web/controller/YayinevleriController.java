package com.turkcell.libraryapp_cqrs.web.controller;

import com.turkcell.libraryapp_cqrs.application.features.yayinevi.command.create.CreateYayineviCommand;
import com.turkcell.libraryapp_cqrs.application.features.yayinevi.command.create.CreatedYayineviResponse;
import com.turkcell.libraryapp_cqrs.core.mediator.Mediator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/yayinevleri")
public class YayinevleriController {

    private final Mediator mediator;

    public YayinevleriController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public CreatedYayineviResponse create(@RequestBody CreateYayineviCommand command) {
        return mediator.send(command);
    }
}
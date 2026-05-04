package com.turkcell.libraryapp_cqrs.application.features.ogrenci.command.create;

import com.turkcell.libraryapp_cqrs.core.mediator.cqrs.Command;

public record CreateOgrenciCommand(
        String ogrenciAd,
        String email
) implements Command<CreatedOgrenciResponse> {
}
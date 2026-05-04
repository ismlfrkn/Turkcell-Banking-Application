package com.turkcell.libraryapp_cqrs.application.features.yazar.command.create;

import com.turkcell.libraryapp_cqrs.core.mediator.cqrs.Command;

import java.util.UUID;

public record CreateYazarCommand(
        String yazarAd,
        String ulke,
        UUID yayineviId
) implements Command<CreatedYazarResponse> {
}
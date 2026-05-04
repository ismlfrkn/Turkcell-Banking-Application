package com.turkcell.libraryapp_cqrs.application.features.adres.command.create;

import com.turkcell.libraryapp_cqrs.core.mediator.cqrs.Command;

public record CreateAdresCommand(
        int ilKod,
        String ilAd,
        String ilceAd,
        String bolge
) implements Command<CreatedAdresResponse> {
}
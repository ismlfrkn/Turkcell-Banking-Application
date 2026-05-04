package com.turkcell.libraryapp_cqrs.application.features.yayinevi.command.create;

import com.turkcell.libraryapp_cqrs.core.mediator.cqrs.Command;

public record CreateYayineviCommand(
        String yayineviAd,
        String telefonNo,
        int ilKodu
) implements Command<CreatedYayineviResponse> {
}
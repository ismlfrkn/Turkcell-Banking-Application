package com.turkcell.libraryapp_cqrs.application.features.kutuphane.command.create;

import com.turkcell.libraryapp_cqrs.core.mediator.cqrs.Command;

import java.time.LocalTime;

public record CreateKutuphaneCommand(
        String kutuphaneAd,
        String telefonNo,
        LocalTime acilisSaati,
        LocalTime kapanisSaati,
        int ilKodu
) implements Command<CreatedKutuphaneResponse> {
}
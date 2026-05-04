package com.turkcell.libraryapp_cqrs.application.features.ogrenci.command.create;

import com.turkcell.libraryapp_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.libraryapp_cqrs.entity.Ogrenci;
import com.turkcell.libraryapp_cqrs.repository.OgrenciRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateOgrenciCommandHandler implements CommandHandler<CreateOgrenciCommand, CreatedOgrenciResponse> {

    private final OgrenciRepository ogrenciRepository;

    public CreateOgrenciCommandHandler(OgrenciRepository ogrenciRepository) {
        this.ogrenciRepository = ogrenciRepository;
    }

    @Override
    public CreatedOgrenciResponse handle(CreateOgrenciCommand command) {
        Ogrenci ogrenci = new Ogrenci();
        ogrenci.setOgrenciAd(command.ogrenciAd());
        ogrenci.setEmail(command.email());

        Ogrenci saved = ogrenciRepository.save(ogrenci);

        return new CreatedOgrenciResponse(
                saved.getOgrenciId(),
                saved.getOgrenciAd(),
                saved.getEmail()
        );
    }
}
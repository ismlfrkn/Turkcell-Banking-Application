package com.turkcell.libraryapp_cqrs.application.features.adres.command.create;

import com.turkcell.libraryapp_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.libraryapp_cqrs.entity.Adres;
import com.turkcell.libraryapp_cqrs.repository.AdresRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateAdresCommandHandler implements CommandHandler<CreateAdresCommand, CreatedAdresResponse> {

    private final AdresRepository adresRepository;

    public CreateAdresCommandHandler(AdresRepository adresRepository) {
        this.adresRepository = adresRepository;
    }

    @Override
    public CreatedAdresResponse handle(CreateAdresCommand command) {
        Adres adres = new Adres();
        adres.setIlKod(command.ilKod());
        adres.setIlAd(command.ilAd());
        adres.setIlceAd(command.ilceAd());
        adres.setBolge(command.bolge());

        Adres saved = adresRepository.save(adres);

        return new CreatedAdresResponse(
                saved.getIlKod(),
                saved.getIlAd(),
                saved.getIlceAd(),
                saved.getBolge()
        );
    }
}
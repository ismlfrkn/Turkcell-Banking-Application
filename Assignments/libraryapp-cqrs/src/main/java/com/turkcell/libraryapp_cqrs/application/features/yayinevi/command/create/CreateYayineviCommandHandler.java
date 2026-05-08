package com.turkcell.libraryapp_cqrs.application.features.yayinevi.command.create;

import com.turkcell.libraryapp_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.libraryapp_cqrs.domain.Adres;
import com.turkcell.libraryapp_cqrs.domain.Yayinevi;
import com.turkcell.libraryapp_cqrs.persistence.repository.AdresRepository;
import com.turkcell.libraryapp_cqrs.persistence.repository.YayineviRepository;

import org.springframework.stereotype.Component;

@Component
public class CreateYayineviCommandHandler implements CommandHandler<CreateYayineviCommand, CreatedYayineviResponse> {

    private final YayineviRepository yayineviRepository;
    private final AdresRepository adresRepository;

    public CreateYayineviCommandHandler(YayineviRepository yayineviRepository, AdresRepository adresRepository) {
        this.yayineviRepository = yayineviRepository;
        this.adresRepository = adresRepository;
    }

    @Override
    public CreatedYayineviResponse handle(CreateYayineviCommand command) {
        Adres adres = adresRepository.findById(command.ilKodu())
                .orElseThrow(() -> new RuntimeException("Adres bulunamadı."));

        Yayinevi yayinevi = new Yayinevi();
        yayinevi.setYayineviAd(command.yayineviAd());
        yayinevi.setTelefonNo(command.telefonNo());
        yayinevi.setAdres(adres);

        Yayinevi saved = yayineviRepository.save(yayinevi);

        return new CreatedYayineviResponse(
                saved.getYayineviNo(),
                saved.getYayineviAd(),
                saved.getTelefonNo(),
                saved.getAdres().getIlKod()
        );
    }
}
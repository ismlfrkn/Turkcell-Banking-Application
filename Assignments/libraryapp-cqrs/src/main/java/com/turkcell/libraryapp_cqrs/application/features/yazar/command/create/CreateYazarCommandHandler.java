package com.turkcell.libraryapp_cqrs.application.features.yazar.command.create;

import com.turkcell.libraryapp_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.libraryapp_cqrs.domain.Yayinevi;
import com.turkcell.libraryapp_cqrs.domain.Yazar;
import com.turkcell.libraryapp_cqrs.persistence.repository.YayineviRepository;
import com.turkcell.libraryapp_cqrs.persistence.repository.YazarRepository;

import org.springframework.stereotype.Component;

@Component
public class CreateYazarCommandHandler implements CommandHandler<CreateYazarCommand, CreatedYazarResponse> {

    private final YazarRepository yazarRepository;
    private final YayineviRepository yayineviRepository;

    public CreateYazarCommandHandler(YazarRepository yazarRepository, YayineviRepository yayineviRepository) {
        this.yazarRepository = yazarRepository;
        this.yayineviRepository = yayineviRepository;
    }

    @Override
    public CreatedYazarResponse handle(CreateYazarCommand command) {
        Yayinevi yayinevi = yayineviRepository.findById(command.yayineviId())
                .orElseThrow(() -> new RuntimeException("Yayınevi bulunamadı."));

        Yazar yazar = new Yazar();
        yazar.setYazarAd(command.yazarAd());
        yazar.setUlke(command.ulke());
        yazar.setYayinevi(yayinevi);

        Yazar saved = yazarRepository.save(yazar);

        return new CreatedYazarResponse(
                saved.getYazarNo(),
                saved.getYazarAd(),
                saved.getUlke(),
                saved.getYayinevi().getYayineviNo()
        );
    }
}
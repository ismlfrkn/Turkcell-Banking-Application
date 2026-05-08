package com.turkcell.libraryapp_cqrs.application.features.kutuphane.command.create;

import com.turkcell.libraryapp_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.libraryapp_cqrs.domain.Adres;
import com.turkcell.libraryapp_cqrs.domain.Kutuphane;
import com.turkcell.libraryapp_cqrs.persistence.repository.AdresRepository;
import com.turkcell.libraryapp_cqrs.persistence.repository.KutuphaneRepository;

import org.springframework.stereotype.Component;

@Component
public class CreateKutuphaneCommandHandler implements CommandHandler<CreateKutuphaneCommand, CreatedKutuphaneResponse> {

    private final KutuphaneRepository kutuphaneRepository;
    private final AdresRepository adresRepository;

    public CreateKutuphaneCommandHandler(
            KutuphaneRepository kutuphaneRepository,
            AdresRepository adresRepository
    ) {
        this.kutuphaneRepository = kutuphaneRepository;
        this.adresRepository = adresRepository;
    }

    @Override
    public CreatedKutuphaneResponse handle(CreateKutuphaneCommand command) {
        Adres adres = adresRepository.findById(command.ilKodu())
                .orElseThrow(() -> new RuntimeException("Adres bulunamadı."));

        Kutuphane kutuphane = new Kutuphane();
        kutuphane.setKutuphaneAd(command.kutuphaneAd());
        kutuphane.setTelefonNo(command.telefonNo());
        kutuphane.setAcilisSaati(command.acilisSaati());
        kutuphane.setKapanisSaati(command.kapanisSaati());
        kutuphane.setAdres(adres);

        Kutuphane saved = kutuphaneRepository.save(kutuphane);

        return new CreatedKutuphaneResponse(
                saved.getKutuphaneId(),
                saved.getKutuphaneAd(),
                saved.getTelefonNo(),
                saved.getAcilisSaati(),
                saved.getKapanisSaati(),
                saved.getAdres().getIlKod()
        );
    }
}
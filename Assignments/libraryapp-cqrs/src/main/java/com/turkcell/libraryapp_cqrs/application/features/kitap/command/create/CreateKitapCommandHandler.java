package com.turkcell.libraryapp_cqrs.application.features.kitap.command.create;

import com.turkcell.libraryapp_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.libraryapp_cqrs.entity.Kitap;
import com.turkcell.libraryapp_cqrs.entity.Yayinevi;
import com.turkcell.libraryapp_cqrs.entity.Yazar;
import com.turkcell.libraryapp_cqrs.repository.KitapRepository;
import com.turkcell.libraryapp_cqrs.repository.YayineviRepository;
import com.turkcell.libraryapp_cqrs.repository.YazarRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateKitapCommandHandler implements CommandHandler<CreateKitapCommand, CreatedKitapResponse> {

    private final KitapRepository kitapRepository;
    private final YayineviRepository yayineviRepository;
    private final YazarRepository yazarRepository;

    public CreateKitapCommandHandler(
            KitapRepository kitapRepository,
            YayineviRepository yayineviRepository,
            YazarRepository yazarRepository
    ) {
        this.kitapRepository = kitapRepository;
        this.yayineviRepository = yayineviRepository;
        this.yazarRepository = yazarRepository;
    }

    @Override
    public CreatedKitapResponse handle(CreateKitapCommand command) {
        Yayinevi yayinevi = yayineviRepository.findById(command.yayineviId())
                .orElseThrow(() -> new RuntimeException("Yayınevi bulunamadı."));

        Yazar yazar = yazarRepository.findById(command.yazarId())
                .orElseThrow(() -> new RuntimeException("Yazar bulunamadı."));

        Kitap kitap = new Kitap();
        kitap.setKitapAd(command.kitapAd());
        kitap.setKitapTur(command.kitapTur());
        kitap.setSayfaSayi(command.sayfaSayi());
        kitap.setYayinevi(yayinevi);
        kitap.setYazar(yazar);

        Kitap saved = kitapRepository.save(kitap);

        return new CreatedKitapResponse(
                saved.getKitapId(),
                saved.getKitapAd(),
                saved.getKitapTur(),
                saved.getSayfaSayi(),
                saved.getYayinevi().getYayineviNo(),
                saved.getYazar().getYazarNo()
        );
    }
}
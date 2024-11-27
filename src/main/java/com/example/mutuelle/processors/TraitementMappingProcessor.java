package com.example.mutuelle.processors;

import com.example.mutuelle.Repositories.MedicamentReferentielRepository;
import com.example.mutuelle.models.MedicamentReferentiel;
import com.example.mutuelle.models.Traitement;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TraitementMappingProcessor implements ItemProcessor<Traitement, Traitement> {

    private final MedicamentReferentielRepository referentielRepository;

    public TraitementMappingProcessor(MedicamentReferentielRepository referentielRepository) {
        this.referentielRepository = referentielRepository;
    }

    @Override
    public Traitement process(Traitement traitement) throws Exception {
        Optional<MedicamentReferentiel> referentielOpt = referentielRepository.findByCodeBarre(traitement.getCodeBarre());
        if (referentielOpt.isPresent()) {
            MedicamentReferentiel medicamentReferentiel = referentielOpt.get();

            traitement.setPourcentageRemboursement(medicamentReferentiel.getPourcentageRemboursement());
            traitement.setExiste(true);
        } else {
            traitement.setExiste(false);
        }

        return traitement;
    }
}

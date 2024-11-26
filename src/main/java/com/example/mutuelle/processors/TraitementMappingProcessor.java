package com.example.mutuelle.processors;

import com.example.mutuelle.Repositories.MedicamentReferentielRepository;
import com.example.mutuelle.models.Traitement;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class TraitementMappingProcessor implements ItemProcessor<Traitement, Traitement> {

    private final MedicamentReferentielRepository referentielRepository;

    public TraitementMappingProcessor(MedicamentReferentielRepository referentielRepository) {
        this.referentielRepository = referentielRepository;
    }

    @Override
    public Traitement process(Traitement traitement) throws Exception {
        // Map treatment to MedicamentReferentiel
        boolean isDisponible = referentielRepository.existsByNom(traitement.getNomMedicament());
        traitement.setExiste(isDisponible);
        return traitement;
    }
}

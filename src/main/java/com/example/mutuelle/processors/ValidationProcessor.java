package com.example.mutuelle.processors;

import com.example.mutuelle.models.Dossier;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ValidationProcessor implements ItemProcessor<Dossier, Dossier> {

    @Override
    public Dossier process(Dossier dossier) throws Exception {
        if (dossier.getNomAssure() == null || dossier.getNumeroAffiliation() == null) {
            throw new IllegalArgumentException("Nom Assure and Numero Affiliation must not be null");
        }
        if (dossier.getPrixConsultation() <= 0) {
            throw new IllegalArgumentException("Prix Consultation must be positive");
        }
        return dossier;
    }
}

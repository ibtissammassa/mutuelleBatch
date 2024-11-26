package com.example.mutuelle.processors;

import com.example.mutuelle.models.Traitement;
import com.example.mutuelle.Repositories.MedicamentReferentielRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class TraitementRemboursementProcessor implements ItemProcessor<Traitement, Traitement> {

    @Override
    public Traitement process(Traitement traitement) throws Exception {
        if (traitement.isExiste()) {
            double remboursement = traitement.getPrixMedicament() * traitement.getPourcentageRemboursement();
            traitement.setMontantRemboursement(remboursement);
        } else {
            traitement.setMontantRemboursement(0.0);
        }

        return traitement;
    }
}

package com.example.mutuelle.processors;

import com.example.mutuelle.models.Traitement;
import com.example.mutuelle.Repositories.MedicamentReferentielRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class TraitementRemboursementProcessor implements ItemProcessor<Traitement, Traitement> {

    private final MedicamentReferentielRepository referentielRepository;

    public TraitementRemboursementProcessor(MedicamentReferentielRepository referentielRepository) {
        this.referentielRepository = referentielRepository;
    }

    @Override
    public Traitement process(Traitement traitement) throws Exception {
        // Find the reference medication
        var medicament = referentielRepository.findByNom(traitement.getNomMedicament());

        if (medicament != null && traitement.isExiste()) {
            // Calculate reimbursement amount for treatment
            double montantRemboursement = medicament.getPrix() * medicament.getPourcentageRemboursement();
            traitement.setMontantRemboursement(montantRemboursement);
        }
        return traitement;
    }
}

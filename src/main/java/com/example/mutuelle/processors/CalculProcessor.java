package com.example.mutuelle.processors;

import com.example.mutuelle.models.Dossier;
import com.example.mutuelle.models.Traitement;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CalculProcessor implements ItemProcessor<Dossier, Dossier> {

    private static final double CONSULTATION_REIMBURSEMENT_RATE = 0.7;

    @Override
    public Dossier process(Dossier dossier) throws Exception {
        double consultationReimbursement = dossier.getPrixConsultation() * CONSULTATION_REIMBURSEMENT_RATE;
        double totalReimbursement = consultationReimbursement;

        for (Traitement traitement : dossier.getTraitements()) {
            if (traitement.isExiste()) {
                double traitementReimbursement = traitement.getPrixMedicament() * 0.8; // Ex
                totalReimbursement += traitementReimbursement;
            }
        }
        dossier.setMontantTotalFrais(totalReimbursement);
        return dossier;
    }
}


package com.example.mutuelle.processors;

import com.example.mutuelle.models.Dossier;
import com.example.mutuelle.models.Traitement;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TotalRemboursementProcessor implements ItemProcessor<Dossier, Dossier> {

    @Override
    public Dossier process(Dossier dossier) throws Exception {
        double totalRemboursement = 0;

        List<Traitement> traitements = dossier.getTraitements();
        if (traitements != null) {
            for (Traitement traitement : traitements) {
                totalRemboursement += traitement.getMontantRemboursement();
            }
        }

        // Add the consultation reimbursement to the total
        totalRemboursement += dossier.getMontantTotalFrais();
        dossier.setTotalRemboursement(totalRemboursement);

        return dossier;

    }
}

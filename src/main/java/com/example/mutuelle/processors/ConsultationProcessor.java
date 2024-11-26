package com.example.mutuelle.processors;

import com.example.mutuelle.models.Dossier;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ConsultationProcessor implements ItemProcessor<Dossier, Dossier> {

    private final double pourcentageConsultation = 0.8; // 80% of the consultation price

    @Override
    public Dossier process(Dossier dossier) throws Exception {
        // Calculate the consultation reimbursement
        double remboursementConsultation = dossier.getPrixConsultation() * pourcentageConsultation;
        dossier.setMontantTotalFrais(dossier.getMontantTotalFrais() + remboursementConsultation);
        return dossier;
    }
}

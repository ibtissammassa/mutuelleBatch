package com.example.mutuelle.processors;

import com.example.mutuelle.models.Dossier;
import com.example.mutuelle.models.Traitement;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CalculProcessor implements ItemProcessor<Dossier, Dossier> {

    private final ValidationProcessor validationProcessor;
    private final ConsultationProcessor consultationProcessor;
    private final TraitementMappingProcessor traitementMappingProcessor;
    private final TraitementRemboursementProcessor traitementRemboursementProcessor;
    private final TotalRemboursementProcessor totalRemboursementProcessor;

    public CalculProcessor(ValidationProcessor validationProcessor,
                           ConsultationProcessor consultationProcessor,
                           TraitementMappingProcessor traitementMappingProcessor,
                           TraitementRemboursementProcessor traitementRemboursementProcessor,
                           TotalRemboursementProcessor totalRemboursementProcessor) {
        this.validationProcessor = validationProcessor;
        this.consultationProcessor = consultationProcessor;
        this.traitementMappingProcessor = traitementMappingProcessor;
        this.traitementRemboursementProcessor = traitementRemboursementProcessor;
        this.totalRemboursementProcessor = totalRemboursementProcessor;
    }

    @Override
    public Dossier process(Dossier dossier) throws Exception {
        // Validate the dossier first
        dossier = validationProcessor.process(dossier);

        // consultation reimbursement
        dossier = consultationProcessor.process(dossier);

        // Process each treatment
        for (Traitement traitement : dossier.getTraitements()) {
            traitement = traitementMappingProcessor.process(traitement);
            traitementRemboursementProcessor.process(traitement);
        }

        // Calcule total reimbursement
        dossier = totalRemboursementProcessor.process(dossier);

        return dossier;
    }
}

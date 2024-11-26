package com.example.mutuelle.writers;

import com.example.mutuelle.Repositories.DossierRepository;
import com.example.mutuelle.models.Dossier;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseWriter implements ItemWriter<Dossier> {
    @Autowired
    private DossierRepository dossierRepository;

    @Override
    public void write(Chunk<? extends Dossier> dossiers) throws Exception {
        dossierRepository.saveAll(dossiers);
        System.out.println("Saved dossiers: " + dossiers.size());
    }
}

package com.example.mutuelle.writers;

import com.example.mutuelle.models.Dossier;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseWriter implements ItemWriter<Dossier> {

    @Override
    public void write(Chunk<? extends Dossier> dossiers) throws Exception {
        for (Dossier dossier : dossiers) {
            System.out.println("Processed dossier for " + dossier.getNomAssure());
        }
    }
}

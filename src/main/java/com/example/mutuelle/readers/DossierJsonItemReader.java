package com.example.mutuelle.readers;

import com.example.mutuelle.models.Dossier;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class DossierJsonItemReader {

    public JsonItemReader<Dossier> dossierJsonItemReader() {
        return new JsonItemReaderBuilder<Dossier>()
                .jsonObjectReader(new JacksonJsonObjectReader<>(Dossier.class))
                .resource(new ClassPathResource("dossiers.json"))
                .name("dossierJsonItemReader")
                .build();
    }
}

package com.example.mutuelle.config;

import com.example.mutuelle.models.Dossier;
import com.example.mutuelle.processors.CalculProcessor;
import com.example.mutuelle.processors.ValidationProcessor;
import com.example.mutuelle.readers.DossierJsonItemReader;
import com.example.mutuelle.writers.DatabaseWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final DossierJsonItemReader reader;
    private final ValidationProcessor validationProcessor;
    private final CalculProcessor calculProcessor;
    private final DatabaseWriter writer;

    public BatchConfig(JobRepository jobRepository,
                       PlatformTransactionManager transactionManager,
                       DossierJsonItemReader reader,
                       ValidationProcessor validationProcessor,
                       CalculProcessor calculProcessor,
                       DatabaseWriter writer) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
        this.reader = reader;
        this.validationProcessor = validationProcessor;
        this.calculProcessor = calculProcessor;
        this.writer = writer;
    }

    @Bean
    public Step step1() {
        return new StepBuilder("dossier-step", jobRepository)
                .<Dossier, Dossier>chunk(5, transactionManager)
                .reader(reader.dossierJsonItemReader())
                .processor(new CompositeItemProcessor<>(validationProcessor, calculProcessor))
                .writer(writer)
                .build();
    }

    @Bean
    public Job dossierJob() {
        return new JobBuilder("dossier-job", jobRepository)
                .start(step1())
                .build();
    }
}

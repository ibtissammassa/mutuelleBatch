package com.example.mutuelle;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MutuelleApplication {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job mutuelleDossierJob;

	public static void main(String[] args) {
		SpringApplication.run(MutuelleApplication.class, args);
	}

	@Bean
	CommandLineRunner runBatch() {
		return args -> {
			JobParameters params = new JobParametersBuilder()
					.addLong("time", System.currentTimeMillis())
					.toJobParameters();
			try {
				JobExecution execution = jobLauncher.run(mutuelleDossierJob, params);
				System.out.println("Batch Status: " + execution.getStatus());
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	}
}


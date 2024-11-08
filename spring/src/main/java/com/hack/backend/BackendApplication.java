package com.hack.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(BackendApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner run(FastApiClient fastApiClient) {
		return args -> fastApiClient.callFastApi();
	}

	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}*/

}

package br.com.tetra.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class TechApplication {
	@Bean
	public WebClient webClient(WebClient.Builder builder) {
		return builder.baseUrl("https://servicodados.ibge.gov.br/api/v1/projecoes/populacao")
		.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(TechApplication.class, args);
	}

}

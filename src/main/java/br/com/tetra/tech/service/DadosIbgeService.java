package br.com.tetra.tech.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.tetra.tech.model.DadosIbge;

@Service
public class DadosIbgeService {
	
	public DadosIbge getDadosIbge(Long numero) {
		
		RestTemplate template = new RestTemplate();
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		template = restTemplateBuilder.build();

		DadosIbge dados = template.getForObject("https://servicodados.ibge.gov.br/api/v1/projecoes/populacao/"+ numero, DadosIbge.class);
		return dados;
	}

}

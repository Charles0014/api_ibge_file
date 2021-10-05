package br.com.tetra.tech.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tetra.tech.model.DadosIbge;
import br.com.tetra.tech.service.DadosIbgeService;

@Service
public class DadosIbgeBusiness {
	
	@Autowired
	private DadosIbgeService service;
	
	public DadosIbge getDadosIbge(Long numero) {   
		return service.getDadosIbge(numero);
	}
}

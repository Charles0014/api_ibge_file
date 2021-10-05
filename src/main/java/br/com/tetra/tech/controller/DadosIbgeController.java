package br.com.tetra.tech.controller;


import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.tetra.tech.business.DadosIbgeBusiness;
import br.com.tetra.tech.model.DadosIbge;
import br.com.tetra.tech.model.FileManipulation;

@Controller
@RequestMapping("/dadosIbge")
public class DadosIbgeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DadosIbgeController.class);
	
	@Autowired
	private DadosIbgeBusiness business;
	
	@Autowired 
	private FileManipulation fileManipulation;
	
	@GetMapping("/{numero}")
	public ResponseEntity<DadosIbge> getDadosIbge(@PathVariable Long numero){
		DadosIbge dados = new DadosIbge();
		try {
			dados = this.business.getDadosIbge(numero);
			fileManipulation.writeFile(dados);
		}catch (Exception e) {
			LOGGER.info("Erro: " + e);
		}
		return ResponseEntity.ok(dados);

	}
	

	@ResponseBody
	@GetMapping("/ultimas")
	public List<String> getUltimasSolicitacao(){
		File arquivo = new File("C://Temp/API_IBGE.txt");
		return fileManipulation.fileReader(arquivo);
		
	}

}

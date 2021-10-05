package br.com.tetra.tech.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.tetra.tech.model.FileManipulation;
import br.com.tetra.tech.model.dto.ProjecaoResponseDto;
import br.com.tetra.tech.service.ProjecaoService;

@Controller
@RequestMapping("v1/projecao")
public class ProjecaoController {

	@Autowired
	private FileManipulation fm;

	private final ProjecaoService service;

	public ProjecaoController(ProjecaoService service) {
		this.service = service;
	}

	@GetMapping(value = "{dataFutura}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ProjecaoResponseDto> handle(@PathVariable("dataFutura") String dataFutura)
			throws URISyntaxException, IOException {
		ProjecaoResponseDto response = service.execute(dataFutura);
		return ResponseEntity.ok(response);
	}

	@ResponseBody
	@GetMapping("/ultimas")
	public List<String> getUltimasSolicitacao() throws IOException {
		return fm.fileReader();
	}

}

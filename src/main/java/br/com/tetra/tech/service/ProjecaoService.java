package br.com.tetra.tech.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.tetra.tech.model.FileManipulation;
import br.com.tetra.tech.model.dto.IbgePopulacaoDto;
import br.com.tetra.tech.model.dto.ProjecaoResponseDto;

@Service
public class ProjecaoService {

	@Value("${service.url}")
	private String ibgePopulacaoUrl;
	FileManipulation fm = new FileManipulation();

	public ProjecaoResponseDto execute(String dataFutura) throws URISyntaxException, IOException {

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

		LocalDateTime dataHoraFutura = LocalDateTime.parse(dataFutura, dateFormatter);

		if (dataHoraFutura.isBefore(LocalDateTime.now())) {
			throw new RuntimeException("Data informada inválida!");
		}

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<IbgePopulacaoDto> responseEntity = restTemplate.getForEntity(ibgePopulacaoUrl,
				IbgePopulacaoDto.class);
		var ibgePopulacaoDto = responseEntity.getBody();

		var dataFuturaEmMillis = dataHoraFutura.atZone(ZoneId.of("America/Sao_Paulo")).toInstant().toEpochMilli();

		var dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		var dataAtual = LocalDateTime.parse(ibgePopulacaoDto.getHorario(), dateTimeFormatter);
		var dataAtualEmMillis = dataAtual.atZone(ZoneId.of("America/Sao_Paulo")).toInstant().toEpochMilli();

		var crescimentoPopulacional = ibgePopulacaoDto.getProjecao().getPopulacao()
				+ ((dataFuturaEmMillis - dataAtualEmMillis)
						/ Long.parseLong(ibgePopulacaoDto.getProjecao().getPeriodoMedio().getIncrementoPopulacional()));

		var log = String.format("%s | %s | %s | %s", dataAtual.format(dateTimeFormatter),
				dataHoraFutura.format(dateTimeFormatter), ibgePopulacaoDto.getProjecao().getPopulacao(),
				crescimentoPopulacional);
		fm.writeFile(log);

		return new ProjecaoResponseDto(ibgePopulacaoDto.getProjecao().getPopulacao(), crescimentoPopulacional);
	}

}

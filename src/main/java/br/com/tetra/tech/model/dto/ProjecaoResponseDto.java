package br.com.tetra.tech.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ProjecaoResponseDto {

  private final Long populacaoAtual;
  private final Long populacaoProjecao;
}

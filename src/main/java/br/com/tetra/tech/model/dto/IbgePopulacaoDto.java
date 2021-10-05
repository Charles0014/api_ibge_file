package br.com.tetra.tech.model.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class IbgePopulacaoDto {

  private String localidade;
  private String horario;
  private Projecao projecao;

  @NoArgsConstructor
  @Getter
  @Setter
  public static class Projecao {
    private Long populacao;
    private PeriodoMedio periodoMedio;
  }

  @NoArgsConstructor
  @Getter
  @Setter
  public static class PeriodoMedio {
    private String incrementoPopulacional;
    private String nascimento;
    private String obito;
  }
}

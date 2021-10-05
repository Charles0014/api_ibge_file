package br.com.tetra.tech.model.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProjecaoRequestDto {

  @Pattern(regexp = "BR|0|1|2|3|4|5")
  private String localidade;

  @NotNull
  private LocalDateTime data;

}

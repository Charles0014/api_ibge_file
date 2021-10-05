package br.com.tetra.tech.model;

public class Projecao {
	private Long id;
	private Double populacao;
	private PeriodoMedio periodoMedio;
	
	public Projecao() {
		super();
	}
	
	public Projecao(Long id, Double populacao, PeriodoMedio periodoMedio) {
		super();
		this.id = id;
		this.populacao = populacao;
		this.periodoMedio = periodoMedio;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getPopulacao() {
		return populacao;
	}
	public void setPopulacao(Double populacao) {
		this.populacao = populacao;
	}
	public PeriodoMedio getPeriodoMedio() {
		return periodoMedio;
	}
	public void setPeriodoMedio(PeriodoMedio periodoMedio) {
		this.periodoMedio = periodoMedio;
	}

}

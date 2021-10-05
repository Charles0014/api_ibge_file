package br.com.tetra.tech.model;

public class PeriodoMedio {
	private Long id; 
	private Double incrementoPopulacional;
    private Double nascimento;
    private Double obito;

	

	public PeriodoMedio() {
		super();
	}
	
	public PeriodoMedio(Long id, Double incrementoPopulacional,Double nascimento ,Double obito) {
		super();
		this.id = id;
		this.incrementoPopulacional = incrementoPopulacional;
		this.nascimento = nascimento;
		this.obito = obito;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getIncrementoPopulacional() {
		return incrementoPopulacional;
	}
	public void setIncrementoPopulacional(Double incrementoPopulacional) {
		this.incrementoPopulacional = incrementoPopulacional;
	}
	public Double getNascimento() {
		return nascimento;
	}

	public void setNascimento(Double nascimento) {
		this.nascimento = nascimento;
	}

	public Double getObito() {
		return obito;
	}

	public void setObito(Double obito) {
		this.obito = obito;
	}
}

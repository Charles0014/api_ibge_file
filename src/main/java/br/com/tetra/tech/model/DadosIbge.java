package br.com.tetra.tech.model;

public class DadosIbge {
	private Long id;
	private String localidade;
	private String horario;
	private Projecao projecao;
	
	public DadosIbge() {
		super();
	}
	
	public DadosIbge(Long id, String localidade, String horario, Projecao projecao) {
		super();
		this.id = id;
		this.localidade = localidade;
		this.horario = horario;
		this.projecao = projecao;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Projecao getProjecao() {
		return projecao;
	}
	public void setProjecao(Projecao projecao) {
		this.projecao = projecao;
	}
	
}

package br.com.cursoja.controlecursoja.model.entidade;

public class Professor {
	private long id;
	private String nome;
	private String celular;
	private double valorHora;
	
	public Professor() {
		super();
		this.id = 0;
		this.nome = "";
		this.celular = "";
		this.valorHora = 0.0;
	}
	
	public Professor(long id, String nome, String celular, double valorHora) {
		super();
		this.id = id;
		this.nome = nome;
		this.celular = celular;
		this.valorHora = valorHora;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	
}

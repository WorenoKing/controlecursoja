package br.com.cursoja.controlecursoja.model.entidade;

public class Curso {
	private long id;
	private String nome;
	private double valor;
	
	public Curso() {
		super();
		this.id = 0;
		this.nome = "";
		this.valor = 0.0;
	}
	
	public Curso(long id, String nome, double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
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
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}

package br.com.cursoja.controlecursoja.model.entidade;

public class Usuario {
	private long id;
	private String nome;
	private String login;
	private String senha;
	
	public Usuario() {
		super();
		this.id = 0;
		this.nome = "";
		this.login = "";
		this.senha = "";
	}
	
	public Usuario(long id, String nome, String login, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}

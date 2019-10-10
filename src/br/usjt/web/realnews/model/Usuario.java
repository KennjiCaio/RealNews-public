package br.usjt.web.realnews.model;

public class Usuario {
	private int id;
	private String email;
	private String nome;
	private String senha;
	private boolean adm;

	public Usuario() {

	}
	
	public Usuario(String email, String nome, String senha, boolean adm) {
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.adm = adm;
	}
	
	public Usuario(int id, String email, String nome, String senha, boolean adm) {
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.adm = adm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean getAdm() {
		return adm;
	}

	public void setAdm(boolean adm) {
		this.adm = adm;
	}
	
	@Override
	public String toString() {
		return "id:" + getId() + ", nome: " + getNome() + ", email:" + getEmail() + ", senha: " + getSenha() + ", adm: " + getAdm(); 
	}
}







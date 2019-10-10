package br.usjt.web.realnews.model;

public class Comentario {
	private int id;
	private int idNoticia;
	private Usuario usuario;
	private String texto;

	public Comentario() {

	}
	
	public Comentario(int idNoticia, Usuario usuario, String texto) {
		this.idNoticia = idNoticia;
		this.usuario = usuario;
		this.texto = texto;
	}
	
	public Comentario(int id, int idNoticia, Usuario usuario, String texto) {
		this.id = id;
		this.idNoticia = idNoticia;
		this.usuario = usuario;
		this.texto = texto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@Override
	public String toString() {
		return "id: " + getId() + "idNoticia:" + getIdNoticia() + "Usuario: " + getUsuario().getId() + "textp: " + getTexto();
	}
}

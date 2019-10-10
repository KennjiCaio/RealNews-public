package br.usjt.web.realnews.model;

public class Noticia {
	private int id;
	private int idUsuario;
	private String titulo;
	private String resumo;
	private String texto;
	private String arquivo;

	public Noticia() {

	}

	public Noticia(String titulo, String resumo, String texto, int idUsuario, String arquivo) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.texto = texto;
		this.idUsuario = idUsuario;
		this.arquivo = arquivo;
	}
	
	public Noticia(int id, String titulo, String resumo, String texto, int idUsuario, String arquivo) {
		this.id = id;
		this.titulo = titulo;
		this.resumo = resumo;
		this.texto = texto;
		this.idUsuario = idUsuario;
		this.arquivo = arquivo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	
	@Override
	public String toString() {
		return "id: " + getId()
		+ ", titulo: " + getTitulo()
		+ ", resumo: " + getResumo()
		+ ", texto: " + getTexto()
		+ ", idUsuario: " + getIdUsuario()
		+ ", arquivo: " + getArquivo();
	}
}

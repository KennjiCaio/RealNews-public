package br.usjt.web.realnews.service;

import java.util.ArrayList;

import br.usjt.web.realnews.dao.ComentarioDAO;
import br.usjt.web.realnews.model.Comentario;

public class ComentarioService {

	ComentarioDAO comentarioDAO;
	Comentario comentario;

	public ComentarioService() {
		this.comentarioDAO = new ComentarioDAO();
	}

	public void inserir(Comentario comentario) {
		this.comentarioDAO.inserir(comentario);
	}

	public void alterar(Comentario comentario) {
		this.comentarioDAO.alterar(comentario);
	}

	public void excluir(int id) {
		this.comentarioDAO.excluir(id);
	}

	public Comentario consultar(int id) {
		return comentarioDAO.consultar(id);
	}
	
	public ArrayList<Comentario> listaComentario(int idNoticia){
		return comentarioDAO.listarComentarios(idNoticia);
	}
	
	public int comentarioNoticia() {
		return comentarioDAO.comentarioNoticia();
	}
}

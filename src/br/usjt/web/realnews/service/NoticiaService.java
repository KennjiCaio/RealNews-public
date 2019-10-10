package br.usjt.web.realnews.service;

import java.util.ArrayList;

import br.usjt.web.realnews.dao.NoticiaDAO;
import br.usjt.web.realnews.model.Noticia;

public class NoticiaService {
	NoticiaDAO noticiaDAO;
	Noticia noticia;

	public NoticiaService() {
		this.noticiaDAO = new NoticiaDAO();
	}

	public void inserir(Noticia noticia) {
		this.noticiaDAO.inserir(noticia);
	}

	public void alterar(Noticia noticia) {
		this.noticiaDAO.alterar(noticia);
	}

	public void excluir(int id) {
		this.noticiaDAO.excluir(id);
	}

	public Noticia consultar(int id){
        return noticiaDAO.consultar(id);
	}
	
	public ArrayList<Noticia> listaNoticia(){
		return noticiaDAO.listarNoticias();
	}
	
	public ArrayList<Noticia> listaNoticiaMin(){
		return noticiaDAO.listarNoticiasMin();
	}
	
	public ArrayList<Noticia> listaNoticiaNome(String titulo){
		return noticiaDAO.listarNoticiasNome(titulo);
	}
}

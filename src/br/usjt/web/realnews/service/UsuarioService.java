package br.usjt.web.realnews.service;

import java.util.ArrayList;

import br.usjt.web.realnews.dao.UsuarioDAO;
import br.usjt.web.realnews.model.Usuario;

public class UsuarioService {
	UsuarioDAO usuarioDAO;
	Usuario usuario;

	public UsuarioService() {
		this.usuarioDAO = new UsuarioDAO();
	}

	public int inserir(Usuario usuario) {
		return usuarioDAO.inserir(usuario);
	}

	public void alterar(Usuario usuario) {
		this.usuarioDAO.alterar(usuario);
	}

	public void excluir(int id) {
		this.usuarioDAO.excluir(id);
	}

	public Usuario consultar(int id) {
		return usuarioDAO.consultar(id);
	}
	
	public ArrayList<Usuario> listarUsuarios(){
		return usuarioDAO.listarUsuarios();
	}
	
	public Usuario consultaLogin(Usuario usuario) {
		return usuarioDAO.consultaLogin(usuario);
	}
	
	public ArrayList<Usuario> listaNome(String nome){
		return usuarioDAO.listaNome(nome);
	}
	

}

package br.usjt.web.realnews.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.web.realnews.model.Usuario;
import br.usjt.web.realnews.service.UsuarioService;

/**
 * Servlet implementation class ConsultaUsuario
 */
@WebServlet("/ConsultaUsuario.do")
public class ConsultaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("txtNome");
		
		UsuarioService usuarioService = new UsuarioService();
		ArrayList<Usuario> listaNome = usuarioService.listaNome(nome);
		
		
		
	}

}

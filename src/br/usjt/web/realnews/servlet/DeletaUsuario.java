package br.usjt.web.realnews.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.web.realnews.service.UsuarioService;

@WebServlet("/DeletaUsuario.do")
public class DeletaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioService usuarioService = new UsuarioService();
		usuarioService.excluir(Integer.parseInt(request.getParameter("id")));
		response.sendRedirect("usuarios.jsp");
	}


}

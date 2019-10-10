package br.usjt.web.realnews.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.web.realnews.model.Usuario;
import br.usjt.web.realnews.service.UsuarioService;

/**
 * Servlet implementation class UsuarioAdm
 */
@WebServlet("/UsuarioAdm.do")
public class UsuarioAdm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioService usuarioService = new UsuarioService();
		Usuario usuario = usuarioService.consultar(Integer.parseInt(request.getParameter("id")));
		System.out.println("id" + request.getParameter("id"));
		usuario.setAdm(true);
		usuarioService.alterar(usuario);
		response.getWriter().print("Alteracao feita com sucesso!");
		response.addHeader("REFRESH", "3;URL=usuarios.jsp");	

	}

}

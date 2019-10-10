package br.usjt.web.realnews.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.web.realnews.model.Usuario;
import br.usjt.web.realnews.service.UsuarioService;
import br.usjt.web.realnews.util.Cripto;

@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("txtEmail");
		String senha = request.getParameter("txtSenha");

		Usuario usuario = new Usuario();
		UsuarioService usuarioService = new UsuarioService();
		Cripto cripto = new Cripto();
	
		usuario.setEmail(email);
		Usuario usuarioAutentica = usuarioService.consultaLogin(usuario);
		
		if(usuarioAutentica != null) {
			boolean senhaAutentica = cripto.matching(usuarioAutentica.getSenha(), senha);
			if(email.equals(usuarioAutentica.getEmail()) && senhaAutentica == true) {
				response.getWriter().print("Login realizado com sucesso");
				HttpSession sessao = request.getSession();
				sessao.setAttribute("usuarioLogado", usuarioAutentica);
				response.sendRedirect("index.jsp");
			} 
			else {
				response.getWriter().print("Email ou senha inválidos");
				int valor = 1;
				response.sendRedirect("login.jsp?erro=" + valor);
			}
		}
		else {
			response.getWriter().print("Email não esta cadastrado");
			int valor = 2;
			response.sendRedirect("login.jsp?erro=" + valor);
		}
	}
}

package br.usjt.web.realnews.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.web.realnews.model.Usuario;
import br.usjt.web.realnews.service.UsuarioService;
import br.usjt.web.realnews.util.Cripto;

@WebServlet("/CadastroUsuario.do")
public class CadastroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("txtNome");
		String email = request.getParameter("txtEmail");
		String senha = request.getParameter("txtSenha");
		
		Usuario usuario = new Usuario();
		UsuarioService usuarioService = new UsuarioService();
		Cripto cripto = new Cripto();
		
		try {
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(cripto.convertToMD5(senha));
			usuario.setAdm(false);
			int idGerado = usuarioService.inserir(usuario);
			Usuario usuarioConsulta = usuarioService.consultar(idGerado);
			
			if(idGerado == usuarioConsulta.getId()) {
				response.getWriter().print("Usuario Cadastrado com sucesso!");
				response.sendRedirect("index.jsp");
			}
			else {
				response.getWriter().print("Ocorreu um problema ao cadastrar");
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

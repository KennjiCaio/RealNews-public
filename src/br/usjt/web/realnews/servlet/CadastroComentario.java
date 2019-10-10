package br.usjt.web.realnews.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.web.realnews.model.Comentario;
import br.usjt.web.realnews.model.Usuario;
import br.usjt.web.realnews.service.ComentarioService;

@WebServlet("/CadastroComentario.do")
public class CadastroComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		
		System.out.println(usuario.toString());
		String txtComentario = request.getParameter("txtComentario");
		int idNoticia = Integer.parseInt(request.getParameter("txtId"));
		
		Comentario comentario = new Comentario();
		comentario.setTexto(txtComentario);
		comentario.setIdNoticia(idNoticia);
		comentario.setUsuario(usuario);
		
		ComentarioService comentarioService = new ComentarioService();
		comentarioService.inserir(comentario);
		
		response.getWriter().print("Comentario cadastrado com sucesso!");
		response.sendRedirect("noticia.jsp?login=in&id="+idNoticia);
	}

}

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

/**
 * Servlet implementation class AtualizarUsuario
 */
@WebServlet({ "/AtualizarUsuario", "/AtualizarUsuario.do" })
public class AtualizarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		
		String nome = request.getParameter("txtNome");
		String email = request.getParameter("txtEmail");
		String senha = request.getParameter("txtSenha");
		boolean adm = usuario.getAdm();
		Usuario usuario2 = new Usuario();
		UsuarioService usuarioService = new UsuarioService();
		Cripto cripto = new Cripto();
		int id = usuario.getId();
		
		try {
			usuario2.setAdm(adm);
			usuario2.setNome(nome);
			usuario2.setEmail(email);
			usuario2.setSenha(cripto.convertToMD5(senha));
			usuario2.setId(id);
			usuarioService.alterar(usuario2);
			Usuario usuarioConsulta = usuarioService.consultar(id);
			
			if(usuarioConsulta.getNome().equals(nome)){
				response.getWriter().print("Usuario alterado com sucesso!");
				
				response.sendRedirect("Logout.do");
				//response.sendRedirect("index.jsp");
			}
			else {
				response.getWriter().print("Ocorreu um problema ao cadastrar");
				response.addHeader("REFRESH", "3;URL=index.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

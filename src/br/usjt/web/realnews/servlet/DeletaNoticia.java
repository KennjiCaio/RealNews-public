package br.usjt.web.realnews.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.web.realnews.service.NoticiaService;

@WebServlet("/DeletaNoticia.do")
public class DeletaNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticiaService notService = new NoticiaService();
		notService.excluir(Integer.parseInt(request.getParameter("id")));
		response.sendRedirect("listarnoticias.jsp");
	}


}

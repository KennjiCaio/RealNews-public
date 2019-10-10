<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.usjt.web.realnews.service.*"%>
<%@ page import="br.usjt.web.realnews.model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
	
	</head>
	<body>
		<%
			if (session.getAttribute("usuarioLogado") == null) {
				response.sendRedirect("index.jsp");
			}
			else 
			{
				Usuario user = (Usuario) session.getAttribute("usuarioLogado");
				if (!user.getAdm())
				{
					response.sendRedirect("index.jsp");
				}
			}
		%>
		<jsp:include page="navbar.jsp" />
		<div class="container text-center">
			<h1 class=" display-4 mt-2">Listar a notícia</h1>
			
		</div>
		<div class="container mt-2">
			<div class="table-responsive-sm mt-5">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Titulo</th>
							<th scope="col">Resumo</th>
							<th scope="col">Funções</th>
						</tr>
					</thead>
					<tbody>
					<%
						NoticiaService noticiaService = new NoticiaService();
						ArrayList<Noticia> listaNoticia = noticiaService.listaNoticia();
					%>
					<%for(Noticia noticia : listaNoticia){%>
						<tr>
							<th scope="row"><%=noticia.getId()%></th>
							<td><%=noticia.getTitulo()%></td>
							<td><%=noticia.getResumo()%></td>
							<td>
							<a href="DeletaNoticia.do?id=<%= noticia.getId() %>" style="margin-left: 10px;"><i class="fas fa-trash-alt"></i></a></td>
						</tr>
					<%}%>
				</table>
			</div>
		</div>
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Progma", "no-cache");
			response.setDateHeader("Expires", 0);
		%>
</body>
</html>
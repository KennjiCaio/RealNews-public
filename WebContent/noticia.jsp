<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.usjt.web.realnews.service.*"%>
<%@ page import="br.usjt.web.realnews.model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		
		<%
			NoticiaService noticiaService = new NoticiaService();
		%>
		<%
			String id = request.getParameter("id");
			if (id.equals("")) {
				response.sendRedirect("index.jsp");
			}
		%>
		<%
			Noticia noticia = noticiaService.consultar(Integer.parseInt(request.getParameter("id")));
		%>
		<title><%=noticia.getTitulo()%></title>
	</head>
	<body>
		<jsp:include page="navbar.jsp" />
		
		<div class="container text-center">
			<h1 class="mt-4 display-4"><%=noticia.getTitulo()%></h1>
			<p class="lead mb-4"><%=noticia.getResumo()%></p>
			
			<img src="<%=noticia.getArquivo()%>" class="img-fluid mb-4"
				alt="Responsive image">
			<p class="text-sm-left text-justify"><%=noticia.getTexto()%></p>
		</div>
	
		<div class="container mt-5">
			<div class="my-3 p-3 bg-white rounded shadow-sm">
				<h6 class="border-bottom border-gray pb-2 mb-0">Comentários</h6>
				
				<%
					ComentarioService comentarioService = new ComentarioService();
					UsuarioService usuarioService = new UsuarioService();
					ArrayList<Comentario> listaComentarios = comentarioService.listaComentario(noticia.getId());
					if(listaComentarios != null){
				%>
				<% for(Comentario comentario : listaComentarios){%>
					<%Usuario usuario = usuarioService.consultar(comentario.getUsuario().getId());%>
					<div class="media text-muted pt-3">
						<img
							data-src="holder.js/32x32?theme=thumb&amp;bg=007bff&amp;fg=007bff&amp;size=1"
							alt="32x32" class="mr-2 rounded" style="width: 32px; height: 32px;"
							src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%2232%22%20height%3D%2232%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%2032%2032%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_16a57fb758a%20text%20%7B%20fill%3A%23007bff%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A2pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_16a57fb758a%22%3E%3Crect%20width%3D%2232%22%20height%3D%2232%22%20fill%3D%22%23007bff%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2211.546875%22%20y%3D%2216.9%22%3E32x32%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E"
							data-holder-rendered="true">
						<p
							class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
							<strong class="d-block text-gray-dark"><%=usuario.getNome()%></strong> 
							<%=comentario.getTexto()%>
						</p>
					</div>
				<%
						}
					}
				%>
				
				<% 
					session = request.getSession();
					if(session.getAttribute("usuarioLogado") != null){
				%>
				<div class="media text-muted pt-3">
					<div class="container">
						<form action="CadastroComentario.do" method="POST">
							<div class="form-row justify-content-md-center">
								<div class="col-md-auto col-12">
									<strong class="d-block text-gray-dark">Comente:</strong>
								</div>
								<div class="col-md-8 col-xl-9 col-12">
									<input type="text" class="form-control subclass"
										placeholder="Comentário" name="txtComentario">
								</div>
								<div class="col-md-2 col-12 ">
									<input type="hidden" name="txtId" value="<%=noticia.getId()%>">
									<input type="submit"
										class="form-control subclass btn btn-primary">
								</div>
							</div>
						</form>
					</div>
				</div>
					<%} else{%>
					<div class="media text-muted pt-3">
						<div class="container">
							<p>Faça o login ou cadastre-se para poder comentar!</p>
							<a href="login.jsp">Login</a> <a href="cadastro.jsp">Cadastre-se</a>
						</div>
					</div>
					<%} %>
			</div>
			<%
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
				response.setHeader("Progma", "no-cache");
				response.setDateHeader("Expires", 0);
			%>
	</body>
</html>
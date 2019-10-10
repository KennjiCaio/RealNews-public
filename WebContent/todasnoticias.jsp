<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.usjt.web.realnews.model.*"%>
<%@ page import="br.usjt.web.realnews.service.*"%>
<%@ page import="java.util.*"%><%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
	<head>

	<title>Todas as Noticias</title>
	<link rel="stylesheet" href="css/estilolistanoticias.css">
	
	</head>
	<body>
		<jsp:include page="navbar.jsp" />
	<div class="container text-center">
		<h1 class="mt-4 display-4">Todas as notícias</h1>		
		<div class="row">
		<%
			NoticiaService noticiaService = new NoticiaService();

	
					ArrayList<Noticia> noticia = noticiaService.listaNoticia();
					if (noticia != null)
					{
					for (Noticia not : noticia) {
				%>
				<div class="col-sm-4 ">
					<div class="card mt-4">
						<img src="<%=not.getArquivo()%>" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title"><%=not.getTitulo()%></h5>
							<p class="card-text"><%=not.getResumo()%></p>
							<a href="noticia.jsp?id=<%=not.getId()%>" class="btn btn-primary">Ver
								mais</a>
						</div>
					</div>
				</div>
				<%
					}
					}
				%>
			</div>
	</div>
		
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Progma", "no-cache");
			response.setDateHeader("Expires", 0);
		%>	
		
		
	</body>
</html>
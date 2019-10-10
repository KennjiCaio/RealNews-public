<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="br.usjt.web.realnews.service.*"%>
<%@ page import="br.usjt.web.realnews.model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Bootstrap core CSS -->
		<link rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
			crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="css/estiloindex.css" />
		
		<title>RealNews</title>
	</head>
	<body>
		<jsp:include page="navbar.jsp" />
		
		<%
			ComentarioService comentarioService = new ComentarioService();
			NoticiaService noticiaService = new NoticiaService();
			int idNoticia = comentarioService.comentarioNoticia();
			if(idNoticia != -1){
				Noticia noticiaDestaque = noticiaService.consultar(idNoticia);
		%>
		<div class="container">
			<div class="jumbdestaque jumbotron p-3 p-md-5 text-white rounded mask" style="background-image:url(<%= noticiaDestaque.getArquivo()%>);  ">
				<div class="col-md-6 px-0">
					<h1 class="display-4 font-italic"><%=noticiaDestaque.getTitulo()%></h1>
					<p class="lead my-3"><%=noticiaDestaque.getResumo()%></p>
					<p class="lead mb-0">
						<a href="noticia.jsp?id=<%=noticiaDestaque.getId()%>" class="text-white font-weight-bold">Continue
							lendo...</a>
					</p>
				</div>
			</div>
		</div>
		<%
			} else{%>
				<div class="container">
					<div class="jumbotron p-3 p-md-5 text-white rounded bg-dark">
						<div class="col-md-6 px-0">
							<h1 class="display-4 font-italic">Vazio</h1>
							<p class="lead my-3">Vazio</p>
							<p class="lead mb-0">
								<a href="index.jsp" class="text-white font-weight-bold">Continue
									lendo...</a>
							</p>
						</div>
					</div>
				</div>
			<%}%>
		
		<div class="container text-center">
			<div class="row">
				<%
	
					ArrayList<Noticia> noticia = noticiaService.listaNoticiaMin();
					if (noticia != null)
					{
					for (Noticia not : noticia) {
				%>
				<div class="col-sm-4 ">
					<div class="card mt-4" ">
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
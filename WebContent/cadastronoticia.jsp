<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<link rel="stylesheet" href="css/estilocnoticia.css">
		
		<title>RealNews</title>
	</head>
	<body>
	
		<jsp:include page="navbar.jsp" />
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
	<div class="container ">
			<form action="CadastroNoticia.do" method="POST"
				enctype="multipart/form-data">
				<div class="text-center mb-4">
					<h1 class="h3 text-center mt-5 mb-5 font-weight-normal">Cadastre
						a notícia</h1>
				</div>
				<div class="form-group row">
					<label for="txtTitulo" class="col-sm-2 col-form-label">Título</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="txtTitulo"
							id="txtTitulo" placeholder="Título" required />
					</div>
				</div>
				<div class="form-group row">
					<label for="txtArea" class="col-sm-2 col-form-label">Resumo</label>
					<div class="col-sm-10">
						<textarea class="form-control" id="txtArea" name="txtResumo"
							placeholder="Digite o resumo" required></textarea>
					</div>
				</div>
				<div class="form-group row">
					<label for="txtNoticia" class="col-sm-2 col-form-label">Conteúdo</label>
					<div class="col-sm-10">
						<textarea class="form-control" id="txtNoticia" name="txtTexto"
							placeholder="Digite o conteúdo" required></textarea>
					</div>
				</div>
	
				<div class="custom-file mb-3">
					<input type="file" class="custom-file-input" name="file"
						id="validatedCustomFile" required> <label
						class="custom-file-label" for="validatedCustomFile"></label>
				</div>
	
				<div class="form-group row">
					<div class="col">
						<button type="submit" class="btn btn-primary btn-lg btn-block">Entrar</button>
					</div>
				</div>
			</form>
		</div>
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Progma", "no-cache");
			response.setDateHeader("Expires", 0);
		%>
</body>
</html>
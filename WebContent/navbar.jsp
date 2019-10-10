<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="br.usjt.web.realnews.model.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>Login</title>
		<!-- Bootstrap core CSS -->
		<link rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
			crossorigin="anonymous">
		<link rel="stylesheet"
			href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
			integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
			crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="css/estilonavbar.css" />
		
		<title>RealNews</title>
		</head>
	<body>

	<%
		Usuario user = null;
		session = request.getSession();

		if (session.getAttribute("usuarioLogado") == null) {
			response.sendRedirect("index.jsp");
		}

		else {
			user = (Usuario) session.getAttribute("usuarioLogado");
		}
	%>
	<nav
		class="navbar navbar-expand-lg  navbar navbar-light fixed-top navstyle">
		<a class="navbar-brand " id="navBrand" href="index.jsp">Real News</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li
					class="nav-item <%if (request.getParameter("active") != null) {
				if (request.getParameter("active").equals("home"))
					out.println("active");
			}%>"><a
					class="nav-link " href="index.jsp?active=home">Home </a></li>
				<li
					class="nav-item <%if (request.getParameter("active") != null) {
				if (request.getParameter("active").equals("noticias"))
					out.println("active");
			}%>"><a
					class="nav-link" href="todasnoticias.jsp?active=noticias">Notícias</a>
				</li>
				<%
					if (user != null && user.getAdm())

					{
				%>
				<li
					class="nav-item <%if (request.getParameter("active") != null) {
					if (request.getParameter("active").equals("usuarios")
							|| request.getParameter("active").equals("cnoticia")
							|| request.getParameter("active").equals("lnoticia"))
						out.println("active");
				}%> dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> Administração </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="cadastronoticia.jsp?active=cnoticia">Cadastrar Notícia</a>
						<a class="dropdown-item" href="listarnoticias.jsp?active=lnoticia">Listar Noticias</a>
						<a class="dropdown-item" href="usuarios.jsp">Listar Usuarios</a>
					</div></li>
				<%
					}
				%>
				</ul>
				<ul class="navbar-nav">
				<%
					if (user == null) {
				%>
				<li
					class="nav-item  <%if (request.getParameter("active") != null) {
					if (request.getParameter("active").equals("login"))
						out.println("active");
				}%>">
					<a class="nav-link linksdefault" href="login.jsp?active=login">Login</a>
				</li>
				<li
					class="nav-item <%if (request.getParameter("active") != null) {
					if (request.getParameter("active").equals("cadastro"))
						out.println("active");
				}%>">
					<a class="nav-link " href="cadastro.jsp?active=cadastro">Cadastre-se</a>
				</li>
				<%
					} else if (session.getAttribute("usuarioLogado") != null) {
				%>
				<li
					class="nav-item <%if (request.getParameter("active") != null) {
					if (request.getParameter("active").equals("user"))
						out.println("active");
				}%>"><a
					href="updateuser.jsp?active=user" class=" nav-link ">Olá, <%=user.getNome()%>.
				</a></li>
				<li class="nav-item"><a href="Logout.do" class=" nav-link ">Sair</a></li>
				<%
					}
					response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
					response.setHeader("Progma", "no-cache");
					response.setDateHeader("Expires", 0);
				%>
			</ul>
		</div>
	</nav>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>
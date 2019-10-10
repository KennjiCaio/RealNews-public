<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.usjt.web.realnews.service.*"%>
<%@ page import="br.usjt.web.realnews.model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>Gerenciador de Usuários</title>
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
		<h1 class=" display-4 mt-2">Listar o usuário</h1>
		
	</div>
	<div class="container mt-2">
		<div class="table-responsive-sm mt-5">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Nome</th>
						<th scope="col">Email</th>
						<th scope="col">Funções</th>
					</tr>
				</thead>
				<tbody>
				<%
					UsuarioService usuarioService = new UsuarioService();
					ArrayList<Usuario> listaUsuario = usuarioService.listarUsuarios();
				%>
				<%for(Usuario usuario : listaUsuario){%>
					<tr>
						<th scope="row"><%=usuario.getId()%></th>
						<td><%=usuario.getNome()%></td>
						<td><%=usuario.getEmail()%></td>
						<td><a href="UsuarioAdm.do?id=<%=usuario.getId()%>"><i class="fas fa-user-lock"></i></a>
						<a href="DeletaUsuario.do?id=<%=usuario.getId()%>" style="margin-left: 10px;"><i class="fas fa-trash-alt"></i></a></td>
					</tr>
				<%}%>
				</tbody>
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
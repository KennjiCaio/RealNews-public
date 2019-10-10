<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
	
		<link href="css/estilologin.css" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="navbar.jsp" />
		<% 
			if(request.getParameter("erro") != null){
				int loginTeste = Integer.parseInt(request.getParameter("erro"));
				if( loginTeste == 1){%>
					<label>Email ou senha inválidos</label>
		 		<%}
				if( loginTeste == 2){%>
					<label>Email não esta cadastrado</label>
	 		<%}
			}
		if (session.getAttribute("usuarioLogado") != null) {
			
			response.sendRedirect("index.jsp");
		}

		%>
		
		<form action="Login.do" method="POST" class="form-signin">
			<div class="text-center mb-4">
				<img class="mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
				<h1 class="h3 mb-3 font-weight-normal">Faça seu login</h1>
			</div>
			<div class="form-label-group">
				<input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus="" name="txtEmail">
				<label for="inputEmail">Email</label>
			</div>
			<div class="form-label-group">
				<input type="password" id="inputPassword" class="form-control" placeholder="Password" required="" name="txtSenha">
				<label for="inputPassword">Senha</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
			<p class="mt-5 text-center"><a href="#"> Esqueci minha senha </a> </p>
		</form>
		
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Progma", "no-cache");
			response.setDateHeader("Expires", 0);
		%>
		
		
	</body>
</html>
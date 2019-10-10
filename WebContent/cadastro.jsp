<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>

        <!-- Custom Style -->
        <link rel="stylesheet" href="css/estilocusuario.css">
	</head>
	<body>
	<jsp:include page="navbar.jsp" />
	<%
		if (session.getAttribute("usuarioLogado") != null) {

			response.sendRedirect("index.jsp");
		}
	%>
	<div class="container mt-5">
            <form action="CadastroUsuario.do" method="POST" class="form-signin">
                <div class="text-center mb-4">
                    <h1 class="h3 text-center mt-5 mb-3 font-weight-normal">Faça seu cadastro</h1>
                </div>
                <div class="form-group">
                    <label for="txtNome" >Digite seu nome</label>
                    <input type="text" class="form-control" id="txtNome" aria-describedby="nomeHelp" placeholder="Digite seu nome" required="" autofocus="" name="txtNome">
                </div>
                <div class="form-group">
                    <label for="txtEmail">Digite seu e-mail</label>
                    <input type="email" class="form-control" id="txtEmail" placeholder="Email" required="" autofocus="" name="txtEmail">
                </div>    
                <div class="form-group">
                    <label for="txtSenha">Digite sua senha</label>
                    <input type="password" class="form-control" id="txtSenha" placeholder="Senha" required="" autofocus="" name="txtSenha">
                </div>
                <button type="submit" class="btn btn-lg mt-2 btn-primary btnCadastrar">Cadastrar</button>
            </form>
        </div>
        
        <%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Progma", "no-cache");
			response.setDateHeader("Expires", 0);	
		%>
        
	</body>
</html>
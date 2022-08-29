<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
<title>Cadastro de usuario</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<div class="container">
		<form action="/usuario/incluir" method="post">
			<div class="form-group">
				<label>Nome:</label>	
				<input type="text" name="nome" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>E-mail:</label>
				<input type="email" name="email" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>Senha:</label>			
				<input type="password" name="senha" class="form-control">
			</div>
			<hr>
			<button type="submit" class="btn btn-gray">Cadastrar</button>
		</form>
	</div>
</body>
</html>
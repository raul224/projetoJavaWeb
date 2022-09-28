<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>App Seguros</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<div class="container">
		<h3>Bem vindo ${user.nome}</h3>
	</div>
	<div></div>
	<div class="container">
		<div class="card" style="width: 24rem;">
			<div class="card-body">
				<h5 class="card-title">Raul Pires</h5>
				<h6 class="card-subtitle mb-2 text-muted">raul.pires@al.infnet.edu.br</h6>
				<p class="card-text">Projeto final bloco de Java. Aplicação para gestão de seguros</p>
				<a href="https://github.com/raul224" class="card-link">Meu git</a>
				<a href="https://github.com/raul224/projetoJavaWeb-AppSeguros" class="card-link">Repositorio da aplicação</a>
			</div>
		</div>
	</div>
</body>
</html>
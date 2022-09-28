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
	<div class="container">
		<h2>Totalizadores:</h2>
		<ul class="list-group">
			<li class="list-group-item">Usuario<span class="badge">12</span></li>
			<li class="list-group-item">Cliente<span class="badge">5</span></li>
			<li class="list-group-item">Orçamentos<span class="badge">3</span></li>
			<li class="list-group-item">Seguros<span class="badge">3</span></li>
			<li class="list-group-item">Seguros de veiculos<span class="badge">3</span></li>
			<li class="list-group-item">Seguros de domicilios<span class="badge">3</span></li>
			<li class="list-group-item">Seguros de vidas<span class="badge">3</span></li>
		</ul>
	</div>

</body>
</html>
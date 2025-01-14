<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.Arrays"%>
<%@page import="infnet.edu.seguros.model.domain.Seguro"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
<title>App - Lista</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<div class="container">	
		  <h2>Cadastro de clientes</h2>
		  		<c:if test="${not empty msg}">
		  			<div class="alert alert-danger">
				  		<strong>${msg}</strong>
					</div>
		  		</c:if>
			  
			<form action="/cliente" method="get">
				<button type="submit" class="btn btn-gray">Novo</button>
			</form>
			
			  <p>Listagem de clientes cadastrados:  ${listagem.size()}</p>
			  <table class="table table-striped">
			    <thead>
			      <tr>
			        <th>id</th>
			        <th>Nome</th>
			        <th>Telefone</th>
			        <th>Email</th>
			        <th>Usu�rio</th>
			      </tr>
			    </thead>
			    <tbody>
			    <c:forEach var="a" items="${listagem}">
			      <tr>
			        <td>${a.id}</td>
			        <td>${a.nome}</td>
			        <td>${a.telefone}</td>
			        <td>${a.email}</td>
			        <td>${a.usuario.nome}</td>
			        <td><a href="/cliente/${a.id}/excluir">Excluir</a></td>
			      </tr>
			      </c:forEach>
			    </tbody>
			  </table>
	</div>
</body>
</html>
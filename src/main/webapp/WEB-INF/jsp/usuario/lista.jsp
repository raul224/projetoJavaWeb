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
		
		  <h2>Cadastramentos de Usuario</h2>
		  		<c:if test="${not empty msg}">
		  			<div class="alert alert-success">
				  		<strong>Sucesso!</strong> ${msg}
					</div>
		  		</c:if>
			
			  <p>Listagem de Usuarios Cadastrados:  ${listagem.size()}</p>
			  <table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Id</th>
			        <th>Nome</th>
			        <th>E-mail</th>
			        <th>Senha</th>
			        <th>Admin</th>
			      </tr>
			    </thead>
			    <tbody>
			    
			    <c:forEach var="u" items="${listagem}">
			      <tr>
			        <td>${u.id}</td>
			        <td>${u.nome}</td>
			        <td>${u.email}</td>
			        <td>${u.senha}</td>
			        <td>${u.admin}</td>
					<td>${u.seguros.size()}</td>
			        <td><a href="/usuario/${u.id}/excluir">Excluir</a></td>
			      </tr>
			      </c:forEach>
			    </tbody>
			  </table>
	</div>
</body>
</html>
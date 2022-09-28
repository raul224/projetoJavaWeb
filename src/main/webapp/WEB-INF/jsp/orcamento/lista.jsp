<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.Arrays"%>
<%@page import="infnet.edu.seguros.model.domain.Seguro"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		  <h2>Cadastro de orçamentos</h2>
		  		<c:if test="${not empty msg}">
		  			<div class="alert alert-success">
				  		<strong>Sucesso!</strong> ${msg}
					</div>
		  		</c:if>
			  
			<form action="/orcamento" method="get">
				<button type="submit" class="btn btn-gray">Novo</button>
			</form>
			
			  <p>Listagem de orçamentos:  ${listagem.size()}</p>
			  <table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Id</th>
			        <th>Data de emissao</th>
			        <th>Nome do cliente</th>
			        <th>Quantidade de seguros</th>
			        <th>Usuario responsável</th>
					<th></th>
			      </tr>
			    </thead>
			    <tbody>
			    
			    <c:forEach var="o" items="${listagem}">
			      <tr>
			        <td>${o.id}</td>
			        <td><fmt:parseDate value="${o.dataEmissao}" pattern="yyyy-MM-dd" var="dataFormat" type="date"/>
						<fmt:formatDate pattern="dd/MM/yyyy" value="${dataFormat}"/></td>
			        <td>${o.cliente.nome}</td>
			        <td>${o.seguros.size()}</td>
			        <td>${o.usuario.nome}</td>
			        <td><a href="/orcamento/${o.id}/excluir">Excluir</a></td>
			      </tr>
			      </c:forEach>
			    </tbody>
			  </table>
	</div>
</body>
</html>
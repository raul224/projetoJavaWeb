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
		  <h2>Cadastro de seguros de veiculos</h2>
		  		<c:if test="${not empty msg}">
		  			<div class="alert alert-danger">
						<strong>${msg}</strong>
					</div>
		  		</c:if>
			  
			<form action="/seguro/veiculo" method="get">
				<button type="submit" class="btn btn-gray">Novo</button>
			</form>
			
			  <p>Listagem de Contratos Cadastrados:  ${listagem.size()}</p>        
			  <table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Numero contrato</th>
			        <th>Data assinatura</th>
			        <th>Data fim</th>
			        <th>Valor contrato</th>
			        <th>Valor indenização</th>
					<th>Placa do veiculo</th>
					<th>CRLV do veiculo</th>
					<th>Tipo do veiculo</th>
			        <th>Usuário</th>
					<th></th>
			      </tr>
			    </thead>
			    <tbody>
			    
			    <c:forEach var="a" items="${listagem}">
			      <tr>
			        <td>${a.numeroContrato}</td>
					<td><fmt:parseDate value="${a.dataAssinatura}" pattern="yyyy-MM-dd" var="dataFormat" type="date"/>
					  <fmt:formatDate pattern="dd/MM/yyyy" value="${dataFormat}"/></td>
					<td><fmt:parseDate value="${a.dataFim}" pattern="yyyy-MM-dd" var="dataFormat" type="date"/>
					  <fmt:formatDate pattern="dd/MM/yyyy" value="${dataFormat}"/></td>
			        <td>${a.valorContrato}</td>
			        <td>${a.valorIndenizacao}</td>
					<td>${a.placa}</td>
					<td>${a.crlv}</td>
					<td>${a.tipoVeiculo}</td>
			        <td>${a.usuario.nome}</td>
			        <td><a href="/seguro/veiculo/${a.numeroContrato}/excluir">Excluir</a></td>
			      </tr>
			      </c:forEach>
			    </tbody>
			  </table>
	</div>
</body>
</html>
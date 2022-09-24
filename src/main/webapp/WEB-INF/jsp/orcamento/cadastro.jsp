<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
<title>Cadastro de orçamentos</title>
</head>
<body>
<c:set var="botao" value=""/>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<div class="container">
		<form action="/orcamento/incluir" method="post">
			<div class="form-group">
				<c:if test="${not empty clientes}">
					<label>Cliente:</label>
					<select class="form-control" name="cliente.id">
						<c:forEach var="c" items="${clientes}">
							<option value="${c.id}">${c.nome}</option>
						</c:forEach>
					</select>
				</c:if>
				<c:if test="${empty clientes}">
					<label>Não há clientes cadastrados</label>
					<c:set var="botao" value="disabled"/>
				</c:if>
			</div>
			<hr>
			<div class="form-group">
				<c:if test="${not empty seguros}">
					<label>Seguros:</label>
					<c:forEach var="s" items="seguros">
						<div class="checkbox">
							<label><input name="seguros" type="checkbox" value="${s.numeroContrato}">${s.numeroContrato}</label>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty seguros}">
					<label>Não há seguros cadastrados</label>
					<c:set var="botao" value="disabled"/>
				</c:if>
			</div>
			<hr>
			<button ${botao} type="submit" class="btn btn-gray">Cadastrar</button>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
<title>Cadastro seguro de vida</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<div class="container">
		<form action="/seguro/vida/incluir" method="post">
			<div class="form-group">
				<label>Valor do contrato:</label>
				<input type="number" name="valorContrato" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>Valor indenização:</label>
				<input type="number" name="valorIndenizacao" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>Data de assinatura do contrato:</label>
				<input type="date" name="dataAssinatura" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>Data final do contrato:</label>
				<input type="date" name="dataFim" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>CPF:</label>
				<input type="text" name="cpf" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>Ano de nascimento:</label>
				<input type="number" name="anoNascimento" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>CPF do beneficiario:</label>
				<input type="text" name="cpfBeneficiario" class="form-control">
			</div>
			<hr>
			<button type="submit" class="btn btn-gray">Cadastrar</button>
		</form>
	</div>
</body>
</html>
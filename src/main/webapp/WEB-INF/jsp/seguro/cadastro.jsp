<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
<title>Cadastro de seguros</title>
</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="container">
		<form action="/seguro/incluir" method="post">
			<div class="form-group">
				<label>Valor do contrato:</label>
				<input type="number" name="valorContrato" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>Valor indeniza��o:</label>
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
			<button type="submit" class="btn btn-gray">Cadastrar</button>
		</form>
	</div>
</body>
</html>
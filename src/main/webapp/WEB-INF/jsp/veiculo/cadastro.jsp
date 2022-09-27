<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
<title>Cadastro seguro de veiculo</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<div class="container">
		<form action="/seguro/veiculo/incluir" method="post">
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
				<input type="datetime-local" name="dataAssinatura" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>Data final do contrato:</label>
				<input type="datetime-local" name="dataFim" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>Placa do veiculo:</label>
				<input type="text" name="placa" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>CRLV do veiculo:</label>
				<input type="text" name="crlv" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>Tipo do veiculo:</label>
				<select name="tipoVeiculo">
					<option value="Carro" selected>Carro</option>
					<option value="Moto">Moto</option>
				</select>
			</div>
			<hr>
			<button type="submit" class="btn btn-gray">Cadastrar</button>
		</form>
	</div>
</body>
</html>
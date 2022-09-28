<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="/">Seguros online</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <c:if test="${not empty user}">
			<li><a href="/usuario/listar">Usu�rios</a></li>
	      	<li><a href="/cliente/listar">Clientes</a></li>
			<li><a href="/seguro/listar">Seguros</a></li>
	      	<li><a href="/seguro/veiculo/listar">Seguros de veiculos</a></li>
	      	<li><a href="/seguro/domicilio/listar">Seguros de domicilios</a></li>
	      	<li><a href="/seguro/vida/listar">Seguros de vidas</a></li>
	      	<li><a href="/orcamento/listar">Or�amentos</a></li>
	      </c:if>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <c:if test="${empty user}">
	    	<li><a href="/usuario"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	      	<li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	      </c:if>
	      
	      <c:if test="${not empty user}">
	      	<li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout, ${user.nome}</a></li>
	      </c:if>
	    </ul>
	  </div>
</nav>
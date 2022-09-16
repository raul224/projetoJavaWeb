<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">Seguros online</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="/">Home</a></li>
	      <c:if test="${not empty user}">
			<c:if test="${user.admin}">
			 <li><a href="usuario/listar">Usuário</a></li>
			</c:if>
	      	<li><a href="/cliente/listar">Cliente</a></li>
	      	<li><a href="/seguro/listar">Seguro</a></li>
	      	<li><a href="/seguro/veiculo/listar">Seguro veicular</a></li>
	      	<li><a href="/seguro/domicilio/listar">Seguro domiciliar</a></li>
	      	<li><a href="/seguro/vida/listar">Seguro de vida</a></li>
	      	<li><a href="/orcamento/listar">Orçamento</a></li>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="br.edu.ifsp.arq.iflix.model.Usuario"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html lang="pt-br" data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Iflix</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="icon" type="image/png" href="assets/iflix.svg">

</head>

<style>
.navbar-top {
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	padding: 10px 20px;
	display: flex;
	justify-content: space-between;
	align-items: center;
	z-index: 1000;
	background-color: transparent;
}

.navbar-top .navbar-brand img {
	height: 40px;
}

.navbar-top .btn {
	font-size: 1rem;
	padding: 0.5rem 1.5rem;
}
</style>


<body>



	<c:if test="${not empty mensagem}">

		<div class="${classe} " role="alert">${mensagem}</div>

	</c:if>


	<div class="navbar-top">
		<a class="navbar-brand" href="home.jsp"> <img
			src="assets/iflix.svg" alt="Logo">
		</a>

		<%
		Usuario name = (Usuario) session.getAttribute("usuario");
		if (name != null) {
		%>
		<div class="dropdown">
			<button class="btn btn-success dropdown-toggle" type="button"
				data-bs-toggle="dropdown" aria-expanded="false">
				Olá,
				<%= name.getNome() %>
			</button>
			<ul class="dropdown-menu">
				<li><a class="dropdown-item" href="#">Novo Filme</a></li>
				<li><a class="dropdown-item" href="#">Minha Conta</a></li>
				<li><a class="dropdown-item" href="LogoutServlet">Sair</a></li>
			</ul>
		</div>
		<%
		} 
		%>




	</div>
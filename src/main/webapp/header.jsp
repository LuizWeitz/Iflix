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

	<div class="navbar-top">
		<a class="navbar-brand" href="home.jsp"> <img
			src="assets/iflix.svg" alt="Logo">
		</a>

		<%
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if (usuario != null) {
		%>
		<div class="dropdown">
			<button class="btn btn-success dropdown-toggle" type="button"
				data-bs-toggle="dropdown" aria-expanded="false">
				Olá,
				<%=usuario.getNome()%>
			</button>
			<ul class="dropdown-menu">
				<li><a class="dropdown-item" href="/Iflix/cadastroFilme.jsp">Novo
						Filme</a></li>
				<li><a class="dropdown-item"
					href="/Iflix/editarUsuario?id=	<%=usuario.getId()%>">Minha
						Conta</a></li>
				<li><a class="dropdown-item" href="/Iflix/sair">Sair</a></li>
			</ul>
		</div>
		<%
		} else {
		%>
		<div class="dropdown">
			<button class="btn btn-success dropdown-toggle" type="button"
				data-bs-toggle="dropdown" aria-expanded="false">OPÇÕES</button>
			<ul class="dropdown-menu">
				<li><a class="dropdown-item" href="/Iflix/home.jsp">Home</a></li>
				<li><a class="dropdown-item" href="/Iflix/sobre.jsp">Sobre</a></li>
				<li><a class="dropdown-item" href="/Iflix/login.jsp">Login</a></li>

			</ul>
		</div>

		<%
		}
		%>
	</div>
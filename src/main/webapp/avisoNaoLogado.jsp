<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="header.jsp" />


<main role="main" class="text-center mt-5 pt-5">

	<h1 class="cover-heading">
		<img src="assets/warning.png" alt="Girl in a jacket" width="120"
			height="120">
	</h1>
	<p class="lead">
		Para acessar este recurso, é necessário estar logado. <br> Clique
		no botão abaixo para entrar em sua conta ou criar uma nova.
	</p>

<a href="login.jsp" class="btn btn-outline-success btn-lg px-5">Entrar</a>

</main>


<c:import url="footer.jsp" />
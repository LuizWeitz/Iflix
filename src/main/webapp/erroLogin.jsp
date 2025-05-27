<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="header.jsp" />


<main role="main" class="text-center mt-5 pt-5">

	<h1 class="cover-heading">
		<img src="assets/warning.png" width="120" height="120">
	</h1>
	<p class="lead">Usuário não encontrado ou senha inválida!</p>

	<a href="login.jsp" class="btn btn-outline-success btn-lg px-5">Voltar
		ao Login</a>

</main>


<c:import url="footer.jsp" />
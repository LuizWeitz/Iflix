<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="header.jsp" />

<style>
.hero-section {
	background: linear-gradient(rgba(0, 0, 0, 0.6), rgba(0, 0, 0, 0.6)),
		url('assets/conjuntoFilmes.jpg')
		no-repeat center center/cover;
	color: white;
	min-height: 100vh;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	text-align: center;
	padding: 3rem;
	position: relative;
}

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
}

.navbar-top .navbar-brand img {
	height: 40px;
}

.navbar-top .btn {
	font-size: 1rem;
	padding: 0.5rem 1.5rem;
}

.hero-section .text-content {
	margin-top: 100px; 
	text-align: center;
}


</style>

<main>
	<div class="hero-section">
		
		<div class="text-content">
			<h1 class="display-3 fw-bold">Mergulhe em histórias</h1>
			<h1 class="display-3 fw-bold">que valem a pena</h1>
			<h3 class="fw-normal text-light mb-4">Explore os filmes mais
				vistos e encontre algo incrível para assistir hoje mesmo.</h3>
			<a href="home.jsp"
				class="text-decoration-underline text-light fw-semibold fs-5 d-inline-flex align-items-center gap-2">
				Descubra o que assistir agora <svg
					xmlns="http://www.w3.org/2000/svg" width="20" height="20"
					fill="currentColor" class="bi bi-arrow-right" viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
						d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z" />
                </svg>
			</a>
		</div>
	</div>

	<div id="imensa-variedade-de-filmes" class="bg-dark text-white py-5">
	


	

</main>

<c:import url="footer.jsp" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="header.jsp" />



<!-- Estilos -->
<style>
.hero-section {
	background: linear-gradient(rgba(0, 0, 0, 0.6), rgba(0, 0, 0, 0.6)),
		url('https://github.com/ionutcora-webdevelopment/netflix-clone/blob/master/img/header-img.jpg?raw=true')
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

/* Títulos e Botão dentro da Hero Section */
.hero-section .text-content {
	margin-top: 100px; /* Espaçamento entre o topo e o conteúdo */
	text-align: center;
}

.trending-card {
	position: relative;
	width: 180px;
	margin-right: 15px;
	flex-shrink: 0;
}

.trending-card img {
	width: 100%;
	height: 270px;
	object-fit: cover;
	border-radius: 8px;
}

.trending-number {
	position: absolute;
	bottom: 10px;
	left: 10px;
	font-size: 4rem;
	font-weight: bold;
	color: white;
	text-shadow: 2px 2px 6px black;
}

.trending-title {
	position: absolute;
	bottom: 0;
	width: 100%;
	background: rgba(0, 0, 0, 0.6);
	color: white;
	text-align: center;
	padding: 0.3rem;
	font-weight: bold;
	border-radius: 0 0 8px 8px;
}

.scroll-container {
	overflow-x: auto;
	display: flex;
	gap: 1rem;
	padding-bottom: 1rem;
	scrollbar-width: none;
}

.scroll-container::-webkit-scrollbar {
	display: none;
}
</style>

<!-- Hero Section -->
<main>
	<div class="hero-section">
		<div class="navbar-top">
			<a class="navbar-brand" href="#"> <img src="assets/iflix.svg"
				alt="Logo">
			</a> <a href="login.jsp" class="btn btn-success">Entrar</a>
		</div>

		<!-- Conteúdo Principal -->
		<div class="text-content">
			<h1 class="display-3 fw-bold">Mergulhe em histórias</h1>
			<h1 class="display-3 fw-bold">que valem a pena</h1>
			<h3 class="fw-normal text-light mb-4">Explore os filmes mais
				vistos e encontre algo incrível para assistir hoje mesmo.</h3>
			<a href="#mais-vistos"
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
		<div class="container text-center">
			<h2 class="fw-bold mb-4">Imensa Variedade de Filmes</h2>

			<p class="text-muted"
				style="font-size: 0.9rem; max-width: 600px; margin: 0 auto 1.2rem auto;">
				Nunca foi tão fácil encontrar novas histórias. O Iflix oferece
				acesso a uma biblioteca incomparável de títulos.</p>
				
				
			<div class="scroll-container d-flex justify-content-center">
				<div class="trending-card">

					<img
						src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSoTCB-_QHXQAT3i3o85sL4Dc8BQikRM4YKFZRG7BDQYyu0fbAx"
						alt="You">
					<div class="trending-title">FLOW</div>
				</div>
				<div class="trending-card">

					<img
						src="https://play-lh.googleusercontent.com/D4AAlb1hSJJ3ZA95M6grKDbuUOs_-I16h2nBWgqofjfHIrlvWSj2QrvKgeDTjpKbuwDq=w240-h480-rw"
						alt="Territorial">
					<div class="trending-title">STEVE JOBS</div>
				</div>
				<div class="trending-card">

					<img
						src="https://br.web.img3.acsta.net/c_310_420/medias/nmedia/18/91/08/82/20128877.JPG"
						alt="Fast X">
					<div class="trending-title">MATRIX</div>
				</div>
				<div class="trending-card">

					<img
						src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJCBN8BrE1u9MFgR1gYfr9Gzqo4sd1Nn_gC0fxZIHFEZgdSv11afu7szYLQNgoD2LXdyUxgg"
						alt="Havoc">
					<div class="trending-title">Piratas do Vale...</div>
				</div>
				<div class="trending-card">

					<img
						src="https://br.web.img3.acsta.net/c_310_420/medias/nmedia/18/90/93/20/20120876.jpg"
						alt="Movie 5">
					<div class="trending-title">O Poderoso Chefão</div>
				</div>
			</div>
		</div>
	</div>


	<div id="mais-vistos" class="bg-dark text-white py-5">
		<div class="container text-center">
			<h2 class="fw-bold mb-4">Mais Vistos</h2>
			<div class="scroll-container d-flex justify-content-center">
				<div class="trending-card">
					<div class="trending-number">1</div>
					<img
						src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSoTCB-_QHXQAT3i3o85sL4Dc8BQikRM4YKFZRG7BDQYyu0fbAx"
						alt="You">
					<div class="trending-title">FLOW</div>
				</div>
				<div class="trending-card">
					<div class="trending-number">2</div>
					<img
						src="https://play-lh.googleusercontent.com/D4AAlb1hSJJ3ZA95M6grKDbuUOs_-I16h2nBWgqofjfHIrlvWSj2QrvKgeDTjpKbuwDq=w240-h480-rw"
						alt="Territorial">
					<div class="trending-title">STEVE JOBS</div>
				</div>
				<div class="trending-card">
					<div class="trending-number">3</div>
					<img
						src="https://br.web.img3.acsta.net/c_310_420/medias/nmedia/18/91/08/82/20128877.JPG"
						alt="Fast X">
					<div class="trending-title">MATRIX</div>
				</div>
				<div class="trending-card">
					<div class="trending-number">4</div>
					<img
						src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJCBN8BrE1u9MFgR1gYfr9Gzqo4sd1Nn_gC0fxZIHFEZgdSv11afu7szYLQNgoD2LXdyUxgg"
						alt="Havoc">
					<div class="trending-title">Piratas do Vale...</div>
				</div>
				<div class="trending-card">
					<div class="trending-number">5</div>
					<img
						src="https://br.web.img3.acsta.net/c_310_420/medias/nmedia/18/90/93/20/20120876.jpg"
						alt="Movie 5">
					<div class="trending-title">O Poderoso Chefão</div>
				</div>
			</div>
		</div>
	</div>

</main>

<c:import url="footer.jsp" />

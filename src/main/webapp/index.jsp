<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- lib para trabalhar com if? -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="header.jsp"></c:import>

<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"> <img src="assets/iflix.svg"
			alt="Logo" height="40">
		</a>

		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarCollapse">
			<div class="ms-auto">
				<button class="btn btn-outline-success" type="submit">Entrar</button>
			</div>
		</div>
	</div>
</nav>


<main>
	<style>
.hero-section {
	background: linear-gradient(rgba(0, 0, 0, 0.6), rgba(0, 0, 0, 0.6)),
		url('https://github.com/ionutcora-webdevelopment/netflix-clone/blob/master/img/header-img.jpg?raw=true')
		no-repeat center center;
	background-size: cover;
	color: white;
}

.hero-section h1, .hero-section h3 {
	color: white;
}

.trending-card {
	position: relative;
	width: 180px;
	margin-right: 15px;
	flex-shrink: 0;
}

.trending-card img {
	width: 100%;
	border-radius: 8px;
	height: 270px;
	object-fit: cover;
}

.trending-number {
	position: absolute;
	padding-left: 10px;
	bottom: 10px;
	font-size: 4rem;
	font-weight: bold;
	color: white;
	text-shadow: 2px 2px 6px black;
	z-index: 2;
	bottom: 10px
}

.trending-title {
	position: absolute;
	bottom: 0;
	width: 100%;
	background: rgba(0, 0, 0, 0.6);
	color: white;
	text-align: center;
	padding: 0.3rem 0;
	font-weight: bold;
	border-radius: 0 0 8px 8px;
}

.scroll-container {
	overflow-x: auto;
	display: flex;
	padding-bottom: 1rem;
	scrollbar-width: none;
}

.scroll-container::-webkit-scrollbar {
	display: none;
}

h2 {
	font-weight: bold;
	margin-bottom: 1rem;
}
</style>

	<div
		class="hero-section position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center">
		<div class="col-md-6 p-lg-5 mx-auto mt-2 mb-5">
			<h1 class="display-3 fw-bold">Mergulhe em histórias que valem a
				pena</h1>
			<h3 class="fw-normal text-light mb-4">Explore os filmes mais
				vistos e encontre algo incrível para assistir hoje mesmo.</h3>
			<a href="#mais-vistos"
				class="text-decoration-underline text-light fw-semibold d-inline-flex align-items-center gap-1 fs-5">
				Descubra o que assistir agora <svg
					xmlns="http://www.w3.org/2000/svg" width="20" height="20"
					fill="currentColor" class="bi bi-arrow-right" viewBox="0 0 16 16">
        <path fill-rule="evenodd"
						d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z" />
      </svg>
			</a>
		</div>
	</div>



	<div class="container mt-5">
		<h2>Mais Vistos</h2>
		<div class="scroll-container">

			<div class="trending-card">
				<div class="trending-number">1</div>
				<img
					src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQuUgeMbaFQGngRk-vvtWvddSo0ZAIU2n-Ylw&s"
					alt="You">
				<div class="trending-title">MINECRAFT</div>
			</div>

			<div class="trending-card">
				<div class="trending-number">2</div>
				<img
					src="https://via.placeholder.com/180x270/A0A0A0/000000?text=Territorial"
					alt="Territorial">
				<div class="trending-title">TERRITORIAL</div>
			</div>

			<div class="trending-card">
				<div class="trending-number">3</div>
				<img
					src="https://via.placeholder.com/180x270/000000/FFFFFF?text=Fast+X"
					alt="Fast X">
				<div class="trending-title">FAST X</div>
			</div>

			<div class="trending-card">
				<div class="trending-number">4</div>
				<img
					src="https://via.placeholder.com/180x270/333333/FFFFFF?text=Havoc"
					alt="Havoc">
				<div class="trending-title">HAVOC</div>
			</div>

			<div class="trending-card">
				<div class="trending-number">5</div>
				<img
					src="https://via.placeholder.com/180x270/FFA500/000000?text=Movie+5"
					alt="Movie 5">
				<div class="trending-title">MOVIE 5</div>
			</div>

		</div>
	</div>

	<!--  imensa variedade de FILMES -->
	<!-- 	Nunca foi tão fácil encontrar novas histórias. A Loja Kindle oferece acesso a uma biblioteca incomparável com os livros mais vendidos e mais de 3 milhões de títulos. -->

</main>


<c:import url="footer.jsp"></c:import>
<%@page import="br.edu.ifsp.arq.iflix.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    Usuario usuario = null;
    if (session != null) {
        usuario = (Usuario) session.getAttribute("usuario");
    }
    if (usuario == null) {
        response.sendRedirect("avisoNaoLogado.jsp");
        return;
    }
%>

<c:import url="header.jsp" />

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

.carrossel-container {
	position: relative;
}

.carrossel {
	display: flex;
	gap: 20px;
	overflow-x: auto;
	scroll-behavior: smooth;
	padding: 10px 0;
	scrollbar-width: none;
}

.carrossel::-webkit-scrollbar {
	display: none;
}

.filme-card {
	flex: 0 0 auto;
	width: 180px;
	position: relative;
	cursor: pointer;
}

.filme-card img {
	width: 100%;
	height: 270px;
	object-fit: cover;
	border-radius: 8px;
	background-color: #666;
	box-shadow: 0 4px 8px rgba(100, 100, 100, 0.5);
	transition: transform 0.3s ease;
}

.filme-card:hover img {
	transform: scale(1.05);
}

.btn-nav {
	position: absolute;
	top: 50%;
	transform: translateY(-50%);
	background-color: rgba(0, 0, 0, 0.4);
	border: none;
	color: white;
	width: 40px;
	height: 60px;
	cursor: default;
	z-index: 10;
	border-radius: 5px;
	font-size: 2rem;
	user-select: none;
}

.btn-nav:hover {
	background-color: rgba(0, 0, 0, 0.6);
}

.btn-prev {
	left: 0;
}

.btn-next {
	right: 0;
}
</style>

<main>
	<% 
	    String[] secoes = {"Ação", "Comédia", "Drama", "Terror"};
	    int contador = 0;
	    for (int inicio = 1; inicio <= 37; inicio += 12) { 
	%>
	<div class="bg-dark text-white py-5">
		<div class="container">
			<h2 class="fw-bold mb-4 text-center"><%= secoes[contador++] %></h2>
			<div class="carrossel-container">
				<button class="btn-nav btn-prev">&lt;</button>
				<div class="carrossel">
					<% 
	                    for (int i = inicio; i < inicio + 12; i++) { 
	                %>
					<div class="filme-card">
						<img src="assets/<%=i%>.png" 
							onerror="this.onerror=null; this.src='assets/poster-vazio.png';">
					</div>
					<% } %>
				</div>
				<button class="btn-nav btn-next">&gt;</button>
			</div>
		</div>
	</div>
	<% } %>
</main>

<c:import url="footer.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="header.jsp" />

<main>

<!-- Navbar -->
<div class="navbar-top">
    <a class="navbar-brand" href="#">
        <img src="assets/iflix.svg" alt="Logo">
    </a>
    <div class="dropdown">
        <button class="btn btn-success dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
            Opções
        </button>
        <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Perfil</a></li>
            <li><a class="dropdown-item" href="#">Configurações</a></li>
            <li><a class="dropdown-item" href="LogoutServlet">Logout</a></li>
        </ul>
    </div>
</div>

<!-- Conteúdo -->
<% 
    String[] secoes = {"Ação", "Comédia", "Drama", "Terror"};
    int contador = 0;
    for (int inicio = 1; inicio <= 37; inicio += 12) { 
%>
<div class="bg-dark text-white py-5">
    <div class="container">
        <h2 class="fw-bold mb-4 text-center"><%= secoes[contador++] %></h2>
        <div class="carrossel-container">
            <button class="btn-nav btn-prev" onclick="scrollCarrossel(this, -1)">&lt;</button>
            <div class="carrossel">
                <% 
                    for (int i = inicio; i < inicio + 12; i++) { 
                %>
                <div class="filme-card">
                    <img src="assets/<%=i%>.png" onerror="this.src='assets/poster-vazio.png';">
                </div>
                <% } %>
            </div>
            <button class="btn-nav btn-next" onclick="scrollCarrossel(this, 1)">&gt;</button>
        </div>
    </div>
</div>
<% } %>

</main>

<c:import url="footer.jsp" />

<style>
    body {
        background-color: #000;
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
        overflow-x: hidden;
        scroll-behavior: smooth;
        padding: 10px 0;
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
        transition: transform 0.3s ease;
    }
    .filme-card:hover img {
        transform: scale(1.05);
    }

    .btn-nav {
        position: absolute;
        top: 50%;
        transform: translateY(-50%);
        background-color: transparent;
        border: none;
        color: white;
        width: 40px;
        height: 60px;
        cursor: pointer;
        z-index: 10;
        border-radius: 5px;
        font-size: 2rem;
    }
    .btn-nav:hover {
        background-color: transparent;
    }
    .btn-prev {
        left: -10px;
    }
    .btn-next {
        right: -10px;
    }
</style>

<script>
    function scrollCarrossel(button, direction) {
        const container = button.parentElement.querySelector('.carrossel');
        const scrollAmount = 220;
        container.scrollBy({
            left: scrollAmount * direction,
            behavior: 'smooth'
        });
    }
</script>

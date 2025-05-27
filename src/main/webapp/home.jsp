<%@ page import="java.util.ArrayList"%>
<%@page import="br.edu.ifsp.arq.iflix.dao.FilmeDAO"%>
<%@page import="br.edu.ifsp.arq.iflix.model.Usuario"%>
<%@page import="br.edu.ifsp.arq.iflix.model.Filme"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% 
    FilmeDAO filmeDAO;
	
	filmeDAO = FilmeDAO.getInstance();
	
	
	Usuario usuario = null;
    if (session != null) {
        usuario = (Usuario) session.getAttribute("usuario");
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

<br>
<br>
<br>

	<div class="bg-dark text-white py-5">
		<div class="container">
			<h2 class="fw-bold mb-4 text-center">Ação</h2>
			<%
            try {
                ArrayList<Filme> filmesAcao = filmeDAO.buscarPorGenero("Ação");

                if (filmesAcao.isEmpty()) {
        %>
			<p class="text-center">Nenhum filme de ação disponível no
				momento.</p>
			<%
                } else {
        %>
			<div class="carrossel-container">
				<button class="btn-nav btn-prev">&lt;</button>
				<div class="carrossel">
					<%
					
					
                            for (int i = 0; i < filmesAcao.size(); i++) {
                                Filme filme = filmesAcao.get(i);
                                
                                String urlFilme = (usuario != null) ? "editarFilme?id=" + filme.getId() : "verFilme?id=" + filme.getId();
                        %>
					<div class="filme-card">
						<a href="editarFilme?id=<%= filme.getId() %>"> <img
							src="data:image/png;base64,<%= filme.getImgCapa() %>"
							>
						</a>
					</div>

					<%
                            }
                        %>
				</div>
				<button class="btn-nav btn-next">&gt;</button>
			</div>
			<%
                }
            } catch (Exception e) {
        %>
			<p class="text-center text-danger">Erro ao carregar os filmes de
				ação</p>
			<%
            }
        %>
		</div>
	</div>



	<div class="bg-dark text-white py-5">
		<div class="container">
			<h2 class="fw-bold mb-4 text-center">Romance</h2>
			<%
            try {
                ArrayList<Filme> filmesAcao = filmeDAO.buscarPorGenero("Romance");

                if (filmesAcao.isEmpty()) {
        %>
			<p class="text-center">Nenhum filme de romance disponível no
				momento.</p>
			<%
                } else {
        %>
			<div class="carrossel-container">
				<button class="btn-nav btn-prev">&lt;</button>
				<div class="carrossel">
					<%
                            for (int i = 0; i < filmesAcao.size(); i++) {
                                Filme filme = filmesAcao.get(i);
                        %>
                        
                        
                        
					<div class="filme-card">
						<a href="editarFilme?id=<%= filme.getId() %>"> <img
							src="data:image/png;base64,<%= filme.getImgCapa() %>"
							>
						</a>
					</div>
					<%
                            }
                        %>
				</div>
				<button class="btn-nav btn-next">&gt;</button>
			</div>
			<%
                }
            } catch (Exception e) {
        %>
			<p class="text-center text-danger">Erro ao carregar os filmes de
				romance</p>
			<%
            }
        %>
		</div>
	</div>



	<div class="bg-dark text-white py-5">
		<div class="container">
			<h2 class="fw-bold mb-4 text-center">Comédia</h2>
			<%
            try {
                ArrayList<Filme> filmesAcao = filmeDAO.buscarPorGenero("Comédia");

                if (filmesAcao.isEmpty()) {
        %>
			<p class="text-center">Nenhum filme de comédia disponível no
				momento.</p>
			<%
                } else {
        %>
			<div class="carrossel-container">
				<button class="btn-nav btn-prev">&lt;</button>
				<div class="carrossel">
					<%
                            for (int i = 0; i < filmesAcao.size(); i++) {
                                Filme filme = filmesAcao.get(i);
                        %>
					<div class="filme-card">
						<a href="editarFilme?id=<%= filme.getId() %>"> <img
							src="data:image/png;base64,<%= filme.getImgCapa() %>"
							>
						</a>
					</div>
					<%
                            }
                        %>
				</div>
				<button class="btn-nav btn-next">&gt;</button>
			</div>
			<%
                }
            } catch (Exception e) {
        %>
			<p class="text-center text-danger">Erro ao carregar os filmes de
				comédia.</p>
			<%
            }
        %>
		</div>
	</div>


	<div class="bg-dark text-white py-5">
		<div class="container">
			<h2 class="fw-bold mb-4 text-center">Drama</h2>
			<%
            try {
                ArrayList<Filme> filmesAcao = filmeDAO.buscarPorGenero("Drama");

                if (filmesAcao.isEmpty()) {
        %>
			<p class="text-center">Nenhum filme de drama disponível no
				momento.</p>
			<%
                } else {
        %>
			<div class="carrossel-container">
				<button class="btn-nav btn-prev">&lt;</button>
				<div class="carrossel">
					<%
                            for (int i = 0; i < filmesAcao.size(); i++) {
                                Filme filme = filmesAcao.get(i);
                        %>
				<div class="filme-card">
						<a href="editarFilme?id=<%= filme.getId() %>"> <img
							src="data:image/png;base64,<%= filme.getImgCapa() %>"
							>
						</a>
					</div>
					<%
                            }
                        %>
				</div>
				<button class="btn-nav btn-next">&gt;</button>
			</div>
			<%
                }
            } catch (Exception e) {
        %>
			<p class="text-center text-danger">Erro ao carregar c</p>
			<%
            }
        %>
		</div>
	</div>

</main>

<c:import url="footer.jsp" />
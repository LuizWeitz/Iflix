<%@page import="br.edu.ifsp.arq.iflix.model.Filme"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="header.jsp" />


<main>
	<section>
		<div class="container mt-5">
			<div class="row justify-content-center">
				<div class="col-md-8">

					<div class="card bg-dark text-light border-0 shadow-lg">
						<div class="ratio ratio-21x9">
							<iframe src="https://www.youtube.com/embed/CwXOrWvPBPk"
								title="Shrek Trailer" allowfullscreen></iframe>
						</div>

						<div class="card-body">
							<h2 class="card-title">Shrek</h2>
							<p class="card-text">Para resgatar uma princesa das garras de
								um dragão que cospe fogo, o ogro Shrek se une a um companheiro
								improvável: um burro brincalhão.</p>

							<div class="d-flex flex-wrap gap-3 mt-4">
								<p class="mb-0">
									<strong>Ano Lançamento:</strong> 2001
								</p>
								<p class="mb-0">
									<strong>Duração:</strong> 90 min
								</p>
								<p class="mb-0">
									<strong>Diretor:</strong> Andrew Adamson
								</p>
								<p class="mb-0">
									<strong>Gênero:</strong> Comédia
								</p>
								<p class="mb-0">
									<strong>Idioma:</strong> PT-BR
								</p>
							</div>

							<div class="d-flex justify-content-between mt-4">
								<a href="#" class="btn btn-outline-secondary btn-lg px-6">Voltar</a>

								<div>
									<a href="#" class="btn btn-outline-success btn-lg px-6 me-2">Salvar</a>
									<a href="#" class="btn btn-outline-danger btn-lg px-6">Excluir</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</main>



<c:import url="footer.jsp" />
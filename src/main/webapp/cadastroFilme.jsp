<%@page import="br.edu.ifsp.arq.iflix.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<c:import url="header.jsp"></c:import>

<main>
	<section class="vh-100 gradient-custom">
		<div class="container py-5 h-100 ">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-8 col-lg-4 col-xl-5">
					<div class="card bg-dark text-white mb-5"
						style="border-radius: 1rem;">
						<div class="card-body p-4 text-center">
							<form action="cadastroFilme" method="post"
								enctype="multipart/form-data">
								<div class="form-outline form-white mb-4 text-none">
									<label class="form-label text-start w-100 fs-5" for="titulo">Título</label>
									<input type="text" id="titulo" name="titulo"
										class="text-light bg-transparent mb-0 px-3 py-2 rounded"
											style="width: 100%; border: 1px solid #555;"
										placeholder="Digite o título do filme" required />
								</div>

								<div class="row mb-4">
									<div class="col">
										<label class="form-label text-start w-100 fs-5"
											for="anoLancamento">Gênero</label> <select
											class="form-select" name="genero" required>
											<option value="Ação">Ação</option>
											<option value="Romance">Romance</option>
											<option value="Comédia">Comédia</option>
											<option value="Drama">Drama</option>
										</select>

									</div>

								</div>


								<div class="row mb-4">
									<div class="col">
										<label class="form-label text-start w-100 fs-5"
											for="anoLancamento">Ano de Lançamento</label> <input
											type="text" id="anoLancamento" name="anoLancamento"
											class="text-light bg-transparent mb-0 px-3 py-2 rounded"
											style="width: 100%; border: 1px solid #555;" placeholder="Ex: 2023" required>
									</div>
									<div class="col">
										<label class="form-label text-start w-100 fs-5" for="diretor">Diretor</label>
										<input type="text" id="diretor" name="diretor"
											class="text-light bg-transparent mb-0 px-3 py-2 rounded"
											style="width: 100%; border: 1px solid #555;" placeholder="Nome do diretor" required>
									</div>
								</div>

								<div class="form-outline form-white mb-4">
									<label class="form-label text-start w-100 fs-5" for="sinopse">Sinopse</label>
									<textarea class="form-control" id="sinopse" name="sinopse"
										rows="3" placeholder="Digite a sinopse do filme" required></textarea>
								</div>

								<div class="row mb-4">
									<div class="col">
										<label class="form-label text-start w-100 fs-5" for="idioma">Idioma</label>
										<input type="text" id="idioma" name="idioma"
											class="text-light bg-transparent mb-0 px-3 py-2 rounded"
											style="width: 100%; border: 1px solid #555;" placeholder="Ex: Português" required>
									</div>
									<div class="col">
										<label class="form-label text-start w-100 fs-5" for="duracao">Duração
											(HH:MM)</label> <input type="text" id="duracao" name="duracao"
											class="text-light bg-transparent mb-0 px-3 py-2 rounded"
											style="width: 100%; border: 1px solid #555;" placeholder="Ex: 01:45" required>
									</div>
								</div>

								<div class="form-outline form-white mb-4">
									<label class="form-label text-start w-100 fs-5"
										for="linkTrailer">URL YouTube Trailer (Link Incorporação)</label> <input
										type="text" id="linkTrailer" name="linkTrailer"
										class="text-light bg-transparent mb-0 px-3 py-2 rounded"
											style="width: 100%; border: 1px solid #555;"
										placeholder="Cole o link do trailer no YouTube" required />
								</div>

								<div class="form-outline form-white mb-4">
									<label class="form-label text-start w-100 fs-5" for="formFile">Upload
										Imagem Capa</label> <input class="form-control" type="file"
										id="capaFile" name="capaFile" required>
								</div>

								<div class="d-flex justify-content-between mt-4">
									<a href="/Iflix/home.jsp"
										class="btn btn-outline-secondary btn-lg px-6">Voltar</a>

									<div>
										<button type="submit"
											class="btn btn-outline-success btn-lg px-6">Salvar</button>
									
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</main>

<c:import url="footer.jsp"></c:import>

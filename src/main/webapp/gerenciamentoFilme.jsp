<%@page import="br.edu.ifsp.arq.iflix.model.Usuario"%>
<%@page import="br.edu.ifsp.arq.iflix.model.Filme"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<c:import url="header.jsp" />

<%
Filme filme = (Filme) request.getAttribute("filme");
%>

<main>
	<section>
		<div class="container mt-5">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card bg-dark text-light border-0 shadow-lg">
						<div class="ratio ratio-21x9">
							<iframe src="<%= filme.getLinkTrailer() %>" width="100%"
								height="100%"></iframe>
						</div>

						<form action="editarFilme?id=<%=filme.getId()%>" method="post"
							enctype="multipart/form-data">
							<div class="card-body">
								<h2 class="card-title">
									<input type="text" name="titulo" value="<%=filme.getTitulo()%>"
										class="text-light bg-transparent mb-0 px-3 py-2 rounded"
										style="width: 100%; border: 1px solid #555;" />
								</h2>

								<p class="card-text">
									<textarea name="sinopse" rows="4"
										class="text-light bg-transparent mb-0 px-3 py-2 rounded"
										style="width: 100%; border: 1px solid #555;"><%=filme.getSinopse()%></textarea>
								</p>

								<div class="d-flex flex-wrap gap-3 mt-4">
									<p class="mb-0" style="flex: 1 1 150px;">
										<strong>Ano Lançamento</strong><br /> <input type="number"
											name="anoLancamento" value="<%=filme.getAnoLancamento()%>"
											class="text-light bg-transparent mb-0 px-3 py-2 rounded"
											style="width: 100%; border: 1px solid #555;" />
									</p>

									<p class="mb-0" style="flex: 1 1 150px;">
										<strong>Duração (hh:mm)</strong><br /> <input type="text"
											name="duracao" value="<%=filme.getDuracao()%>"
											class="text-light bg-transparent mb-0 px-3 py-2 rounded"
											style="width: 100%; border: 1px solid #555;" />
									</p>

									<p class="mb-0" style="flex: 1 1 150px;">
										<strong>Diretor</strong><br /> <input type="text"
											name="diretor" value="<%=filme.getDiretor()%>"
											class="text-light bg-transparent mb-0 px-3 py-2 rounded"
											style="width: 100%; border: 1px solid #555;" />
									</p>

									<p class="mb-0" style="flex: 1 1 150px;">
										<strong>Gênero</strong><br /> <select class="form-select"
											name="genero" required>
											<option value="Ação"
												<%=filme.getGenero().equals("Ação") ? "selected" : ""%>>Ação</option>
											<option value="Romance"
												<%=filme.getGenero().equals("Romance") ? "selected" : ""%>>Romance</option>
											<option value="Comédia"
												<%=filme.getGenero().equals("Comédia") ? "selected" : ""%>>Comédia</option>
											<option value="Drama"
												<%=filme.getGenero().equals("Drama") ? "selected" : ""%>>Drama</option>
										</select>
									</p>
									<p class="mb-0" style="flex: 1 1 150px;">
										<strong>Idioma</strong><br /> <input type="text"
											name="idioma" value="<%=filme.getIdioma()%>"
											class="text-light bg-transparent mb-0 px-3 py-2 rounded"
											style="width: 100%; border: 1px solid #555;" />
									</p>
									<p class="mb-0" style="flex: 1 1 150px;">

										<strong>Formato</strong><br /> <input type="text"
											name="formato" value="<%=filme.getFormato()%>"
											class="text-light bg-transparent mb-0 px-3 py-2 rounded"
											style="width: 100%; border: 1px solid #555;" />
									</p>
								</div>

								<div class="d-flex flex-wrap gap-3 mt-4">
									<strong>URL YouTube Trailer (Link Incorporação)</strong><br />
									<input class="form-control" type="text" id="linkTrailer"
										name="linkTrailer" value="<%=filme.getLinkTrailer()%>"
										required>
								</div>

								<div class="d-flex flex-wrap gap-3 mt-4">
									<strong>Upload Imagem Capa</strong><br /> <input
										class="form-control" type="file" id="capaFile" name="capaFile"
										>
								</div>

								<div class="d-flex justify-content-between mt-4">
									<a href="/Iflix/home.js "
										class="btn btn-outline-secondary btn-lg px-6">Voltar</a>
									<div>
										<a href="deleteFilme?id=<%=filme.getId()%>"
											class="btn btn-outline-danger btn-lg px-6">Excluir</a>
										<button type="submit"
											class="btn btn-outline-success btn-lg px-6">Editar</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</main>

<c:import url="footer.jsp" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="header.jsp"></c:import>

<main>
	<section class="vh-90 gradient-custom">
		<div class="container py-5 h-100">
			<div class="row d-flex justify-content-center align-items-center h-800">
				<div class="col-12 col-md-8 col-lg-4 col-xl-5">
					<div class="card bg-dark text-white mb-4" style="border-radius: 1rem;">
						<div class="card-body p-4 text-center">

							<div class="mb-md-2 mt-md-2 pb-1">

								<form action="filme/cadastro" method="post">
									<div class="form-outline form-white mb-4 text-none">
										<label class="form-label text-start w-100 fs-5" for="titulo">Título</label>
										<input type="text" id="titulo" name="titulo" class="form-control form-control-lg" placeholder="Digite o título do filme" required />
									</div>

									<div class="row mb-4">
										<div class="col">
											<label class="form-label text-start w-100 fs-5" for="anoLancamento">Ano de Lançamento</label>
											<input type="text" id="anoLancamento" name="anoLancamento" class="form-control" placeholder="Ex: 2023" required>
										</div>
										<div class="col">
											<label class="form-label text-start w-100 fs-5" for="diretor">Diretor</label>
											<input type="text" id="diretor" name="diretor" class="form-control" placeholder="Nome do diretor" required>
										</div>
									</div>

									<div class="form-outline form-white mb-4">
										<label class="form-label text-start w-100 fs-5" for="sinopse">Sinopse</label>
										<textarea class="form-control" id="sinopse" name="sinopse" rows="3" placeholder="Digite a sinopse do filme" required></textarea>
									</div>

									<div class="row mb-4">
										<div class="col">
											<label class="form-label text-start w-100 fs-5" for="idioma">Idioma</label>
											<input type="text" id="idioma" name="idioma" class="form-control" placeholder="Ex: Português" required>
										</div>
										<div class="col">
											<label class="form-label text-start w-100 fs-5" for="duracao">Duração (HH:MM)</label>
											<input type="text" id="duracao" name="duracao" class="form-control" placeholder="Ex: 01:45" required>
										</div>
									</div>

									<div class="form-outline form-white mb-4">
										<label class="form-label text-start w-100 fs-5" for="linkTrailer">URL YouTube Trailer</label>
										<input type="text" id="linkTrailer" name="linkTrailer" class="form-control" placeholder="Cole o link do trailer no YouTube" required />
									</div>

									<div class="form-outline form-white mb-4">
										<label class="form-label text-start w-100 fs-5" for="formFile">Upload Imagem Capa</label>
										<input class="form-control" type="file" id="formFile" name="capa" required>
									</div>

									<button class="btn btn-outline-success btn-lg px-5" type="submit">Cadastrar</button>
								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</main>

<c:import url="footer.jsp"></c:import>

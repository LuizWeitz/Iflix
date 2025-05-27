<%@page import="br.edu.ifsp.arq.iflix.model.Usuario"%>
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
    Usuario user = (Usuario) request.getAttribute("usuario");
%>

<main>
	<section
		class="vh-100 gradient-custom bg-dark text-white d-flex align-items-center">
		<div class="container py-5">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="card mb-4"
						style="background-color: transparent; border: 1px solid #444;">
						<div class="card-body text-center py-2 px-5">
							<img src="data:image/png;base64,<%= user.getImgPerfil() %>"
								alt="avatar" class="rounded-circle mb-5"
								style="width: 150px; height: 150px; object-fit: cover; border: 3px solid #28a745;">

							<form action="editarUsuario" method="post"
								enctype="multipart/form-data" class="text-start px-3">

								<div class="mb-3 text-start">
									<label class="form-label fs-6" for="imgPerfil">Nova
										Foto de Perfil</label> <input
										class="form-control form-control-sm bg-dark text-white rounded-pill border border-secondary"
										type="file" id="imgPerfil" name="imgPerfil" required />
								</div>

								<input type="hidden" name="id" value="<%= user.getId() %>" />

								<div class="row mb-4">
									<div class="col-sm-4 d-flex align-items-center">
										<p class="mb-0 fw-semibold">Nome</p>
									</div>
									<div class="col-sm-8">
										<input name="nome"
											class="text-light bg-transparent mb-0 px-3 py-2 rounded"
											style="width: 100%; border: 1px solid #555;"
											value="<%= user.getNome() %>" required>
									</div>
								</div>

								<hr style="border-color: #444;" />

								<div class="row mb-4">
									<div class="col-sm-4 d-flex align-items-center">
										<p class="mb-0 fw-semibold">Data de Nascimento</p>
									</div>
									<div class="col-sm-8">
										<input type="date" name="dataNasc"
											class="text-light bg-transparent mb-0 px-3 py-2 rounded"
											style="width: 100%; border: 1px solid #555;"
											value="<%= user.getDataNasc() %>" required>
									</div>
								</div>

								<hr style="border-color: #444;" />

								<div class="row mb-4">
									<div class="col-sm-4 d-flex align-items-center">
										<p class="mb-0 fw-semibold">Email</p>
									</div>
									<div class="col-sm-8">
										<input type="email" name="email"
											class="text-light bg-transparent mb-0 px-3 py-2 rounded"
											style="width: 100%; border: 1px solid #555;"
											value="<%= user.getEmail() %>" required>
									</div>
								</div>

								<hr style="border-color: #444;" />

								<div class="row mb-4">
									<div class="col-sm-4 d-flex align-items-center">
										<p class="mb-0 fw-semibold">Nova Senha</p>
									</div>
									<div class="col-sm-8">
										<input type="password" name="senha"
											class="text-light bg-transparent mb-0 px-3 py-2 rounded"
											style="width: 100%; border: 1px solid #555;" required>
									</div>
								</div>
								<div class="d-flex justify-content-between mt-4">
									<a href="/Iflix/home.jsp"
										class="btn btn-outline-secondary btn-lg px-6">Voltar</a>

									<div>
									
										<a href="deleteUsuario?id=<%= usuario.getId() %>"
											class="btn btn-outline-danger btn-lg px-6">Excluir</a>
									
										<button type="submit"
											class="btn btn-outline-success btn-lg px-6">Editar</button>
									
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

<c:import url="footer.jsp" />

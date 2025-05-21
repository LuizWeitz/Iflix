<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="header.jsp"></c:import>

<main>
    <section class="vh-100 gradient-custom">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-800">
                <div class="col-12 col-md-8 col-lg-4 col-xl-5">
                    <div class="card bg-dark text-white mb-4"
                        style="border-radius: 1rem;">
                        <div class="card-body p-4 text-center">

                            <div class="mb-md-2 mt-md-2 pb-1">

                                <div class="mb-4">
                                    <img src="assets/iflix.svg" alt="Logo" height="70">
                                </div>

                                <form action="cadUsuario" method="post">
                                    <div class="form-outline form-white mb-4 text-none">
                                        <label class="form-label text-start w-100 fs-6" for="nome">Nome</label>
                                        <input type="text" id="nome" name="nome"
                                            class="form-control form-control-sm" required />
                                    </div>

                                    <div class="form-outline form-white mb-4 text-none">
                                        <label class="form-label text-start w-100 fs-6" for="dataNasc">Data
                                            de Nascimento</label> <input type="date" id="dataNasc"
                                            name="dataNasc" class="form-control form-control-sm" required />
                                    </div>

                                    <div class="form-outline form-white mb-4 text-none">
                                        <label class="form-label text-start w-100 fs-6" for="email">Email</label>
                                        <input type="email" id="email" name="email"
                                            class="form-control form-control-sm" required />
                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label text-start w-100 fs-6" for="senha">Senha</label>
                                        <input type="password" id="senha" name="senha"
                                            class="form-control form-control-sm" required />
                                    </div>

                                    <div class="form-check text-start mb-4">

                                        <input class="form-check-input" type="checkbox"
                                            id="termosCheck"> <label
                                            class="form-check-label text-white-50" for="termosCheck"
                                            data-bs-toggle="modal" data-bs-target="#exampleModal">
                                            Li e aceito os <u>termos de uso</u>
                                        </label>
                                    </div>

                                    <div class="modal fade" id="exampleModal" tabindex="-1"
                                        aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content text-dark">
                                                <div class="modal-header">

                                                    <h5 class="modal-title text-light bg-dark"
                                                        id="exampleModalLabel">Termos de Uso</h5>
                                                    <button type="button" class="btn-close"
                                                        data-bs-dismiss="modal" aria-label="Fechar"></button>
                                                </div>
                                                <div class="modal-body text-white">
                                                    <p class="text-muted mt-3"
                                                        style="font-size: 0.9rem; max-width: 600px; margin: auto;">
                                                        <strong>Iflix</strong> é um trabalho de natureza acadêmica
                                                        e tem fins exclusivamente educacionais. As imagens,
                                                        vídeos, trechos de filmes e textos utilizados pertencem
                                                        aos seus respectivos criadores e detentores de direitos
                                                        autorais. Seu uso aqui se dá sob o princípio do uso justo
                                                        (<em>fair use</em>), com propósito de análise e comentário
                                                        crítico.
                                                    </p>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-outline-success"
                                                        data-bs-dismiss="modal">Fechar</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <button class="btn btn-outline-success btn-lg px-5"
                                        type="submit">Cadastrar</button>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>

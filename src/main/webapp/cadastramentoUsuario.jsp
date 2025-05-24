<%@page import="br.edu.ifsp.arq.iflix.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp" />

<main>
  <section class="vh-100 gradient-custom">
    <div class="container py-5 h-100 ">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-8 col-lg-4 col-xl-5">
          <div class="card bg-dark text-white mb-5" style="border-radius: 1rem;">
            <div class="card-body p-4 text-center">

              <div class="mb-4">
                <img src="assets/iflix.svg" alt="Logo" height="70"/>
              </div>

              <form action="cadUsuario" method="post" enctype="multipart/form-data">
                
                <div class="mb-3 text-start">
                  <label class="form-label fs-6" for="formFile">Foto de Perfil</label>
                 <input class="form-control form-control-sm bg-dark text-white rounded-pill border border-secondary" type="file" id="formFile" name="imgPerfil" required />
                </div>

                <div class="mb-3 text-start">
                  <label class="form-label fs-6" for="nome">Nome</label>
                  <input class="form-control form-control-sm bg-dark text-white" id="nome" name="nome" required />
                </div>

                <div class="mb-3 text-start">
                  <label class="form-label fs-6" for="dataNascimento">Data de Nascimento</label>
                  <input type="date" class="form-control form-control-sm bg-dark text-white" id="dataNascimento" name="dataNascimento" required />
                </div>

                <div class="mb-3 text-start">
                  <label class="form-label fs-6" for="email">Email</label>
                  <input type="email" class="form-control form-control-sm bg-dark text-white" id="email" name="email" required />
                </div>

                <div class="mb-3 text-start">
                  <label class="form-label fs-6" for="senha">Senha</label>
                  <input type="password" class="form-control form-control-sm bg-dark text-white" id="senha" name="senha" required />
                </div>

                <div class="form-check text-start mb-3">
                  <input class="form-check-input" type="checkbox" id="termosCheck" required />
                  <label class="form-check-label" for="termosCheck" style="cursor: pointer;" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Li e aceito os <u>termos de uso</u>
                  </label>
                </div>

                <!-- Modal de Termos -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                  <div class="modal-dialog">
                    <div class="modal-content text-dark">
                      <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Termos de Uso</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Fechar"></button>
                      </div>
                      <div class="modal-body text-white">
                        <strong>Iflix</strong> é um trabalho de natureza acadêmica e tem
                        fins exclusivamente educacionais. As imagens, vídeos, trechos de
                        filmes e textos utilizados pertencem aos seus respectivos criadores
                        e detentores de direitos autorais. Seu uso aqui se dá sob o
                        princípio do uso justo (<em>fair use</em>), com propósito de análise
                        e comentário crítico.
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                      </div>
                    </div>
                  </div>
                </div>

                <button class="btn btn-outline-success btn-lg px-5 mt-3" type="submit">Cadastrar</button>

              </form>

              <p class="mt-4 mb-0">
                Já tem uma conta? <a href="login.jsp" class="text-white-50">Entrar</a>
              </p>

            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</main>

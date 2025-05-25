<%@page import="br.edu.ifsp.arq.iflix.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp"/>

<%
    Usuario user = (Usuario) request.getAttribute("usuario");
%>


<main>
  <section class="vh-100 gradient-custom bg-dark text-white d-flex align-items-center">
    <div class="container py-5">
      <div class="row justify-content-center">
        <div class="col-lg-8">

          <div class="card mb-4" style="background-color: transparent; border: 1px solid #444;">
            <div class="card-body text-center py-5 px-5">

              <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"
                   alt="avatar"
                   class="rounded-circle mb-5"
                   style="width: 150px; height: 150px; object-fit: cover; border: 3px solid #28a745;">

              <form action="editarUsuario" method="post" class="text-start px-3">
                <input type="hidden" name="id" value="<%= user.getId() %>" />

                <div class="row mb-4">
                  <div class="col-sm-4 d-flex align-items-center">
                    <p class="mb-0 fw-semibold">Nome</p>
                  </div>
                  <div class="col-sm-8">
                    <input name="nome" class="text-light bg-transparent mb-0 px-3 py-2 rounded" 
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
                    <input type="date" name="dataNasc" class="text-light bg-transparent mb-0 px-3 py-2 rounded" 
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
                    <input type="email" name="email" class="text-light bg-transparent mb-0 px-3 py-2 rounded" 
                           style="width: 100%; border: 1px solid #555;" 
                           value="<%= user.getEmail() %>" required>
                  </div>
                </div>

                <hr style="border-color: #444;" />

                <div class="row mb-4">
                  <div class="col-sm-4 d-flex align-items-center">
                    <p class="mb-0 fw-semibold">Senha</p>
                  </div>
                  <div class="col-sm-8">
                    <input type="password" name="senha" class="text-light bg-transparent mb-0 px-3 py-2 rounded" 
                           style="width: 100%; border: 1px solid #555;" 
                           value="<%= user.getSenha() %>" required>
                  </div>
                </div>

               <div class="d-flex justify-content-center gap-3 mt-4">
				  <form action="editarUsuario" method="post" style="display:inline;">
				    <input type="hidden" name="id" value="<%= user.getId() %>" />
				    <button type="submit" class="btn btn-outline-success px-4">Salvar</button>
				  </form>
				
				  <form action="deleteUsuario" method="get" style="display:inline;">
				    <input type="hidden" name="id" value="<%= user.getId() %>"/>
				    <button type="submit" class="btn btn-danger px-4">Deletar</button>
				  </form>
				</div>


            </div>
          </div>

        </div>
      </div>
    </div>
  </section>
</main>

<c:import url="footer.jsp"/>

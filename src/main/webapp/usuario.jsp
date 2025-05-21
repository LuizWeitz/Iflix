<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp"/>

<main>
  <section class="vh-100 gradient-custom bg-dark text-white">
    <div class="container py-5 h-100">
      <div class="row justify-content-center">
        <div class="col-lg-8">
          
          <div class="card text-white mb-4" style="background-color: transparent; border: 1px solid bg-dark;">
            <div class="card-body text-center">
              <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp" 
                   alt="avatar"
                   class="rounded-circle img-fluid mb-3"
                   style="width: 150px;">
              <h5 class="my-3 mb-5">John Smith</h5>
      
              <div class="text-start px-4">
                <div class="row mb-3">
                  <div class="col-sm-4">
                    <p class="mb-0">Nome</p>
                  </div>
                  <div class="col-sm-8">
                    <p class="text-light mb-0">nome</p>
                  </div>
                </div> 
                <hr class="bg-dark" />
                     <div class="row mb-3">
                  <div class="col-sm-4">
                    <p class="mb-0">Data de Nascimento</p>
                  </div>
                  <div class="col-sm-8">
                    <p class="text-light mb-0">nome</p>
                  </div>
                </div>
                <hr class="bg-dark" />
                <div class="row mb-3">
                  <div class="col-sm-4">
                    <p class="mb-0">Email</p>
                  </div>
                  <div class="col-sm-8">
                    <p class="text-light mb-0">example@example.com</p>
                  </div>
                </div>
                <hr class="bg-dark" />
                <div class="row mb-3">
                  <div class="col-sm-4">
                    <p class="mb-0">Senha</p>
                  </div>
                  <div class="col-sm-8">
                    <p class="text-light mb-0">(097) 234-5678</p>
                  </div>
                </div>
                  <div class="d-flex justify-content-center mb-4">
                   <button type="button" class="btn btn-outline-success me-2">Editar</button>
                   <button type="button" class="btn btn-success">Deletar</button>
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

<%@page import="br.edu.ifsp.arq.iflix.model.Usuario"%>
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
            <div class="form-outline form-white mb-4">
										<label class="form-label text-start w-100 fs-5" for="formFile">Upload Imagem Capa</label>
										<input class="form-control" type="file" id="formFile" name="capa" required>
									</div>
              <div class="text-start px-4">
                <div class="row mb-3">
                  <div class="col-sm-4">
                    <p class="mb-0">Nome</p>
                  </div>
                  <div class="col-sm-8">
                    <input class="text-light mb-0" value="">
                  </div>
                </div> 
                <hr class="bg-dark" />
                     <div class="row mb-3">
                  <div class="col-sm-4">
                    <p class="mb-0">Data de Nascimento</p>
                  </div>
                  <div class="col-sm-8">
                      <input class="text-light mb-0" value="">
                  </div>
                </div>
                <hr class="bg-dark" />
                <div class="row mb-3">
                  <div class="col-sm-4">
                    <p class="mb-0">Email</p>
                  </div>
                  <div class="col-sm-8">
                    <input class="text-light mb-0" value="">
                  </div>
                </div>
                <hr class="bg-dark" />
                <div class="row mb-3">
                  <div class="col-sm-4">
                    <p class="mb-0">Senha</p>
                  </div>
                  <div class="col-sm-8">
                   <input class="text-light mb-0">
                  </div>
                </div>
                  <div class="d-flex justify-content-center mb-4">
                   <button type="button" class="btn btn-success" >Voltar</button>
                   <button type="button"class="btn btn-outline-success me-4" >Salvar</button>
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

<%@page import="br.edu.ifsp.arq.iflix.model.Usuario"%>
<%@page import="br.edu.ifsp.arq.iflix.model.Filme"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
                            <iframe src="<%= filme.getLinkTrailer() %>" width="100%" height="100%"></iframe>
                        </div>

                        <div class="card-body">
                            <h2 class="card-title">
                                <%= filme.getTitulo() %>
                            </h2>

                            <p class="card-text">
                                <%= filme.getSinopse() %>
                            </p>

                            <div class="d-flex flex-wrap gap-3 mt-4">
                                <p class="mb-0" style="flex: 1 1 150px;">
                                    <strong>Ano Lançamento:</strong><br />
                                    <%= filme.getAnoLancamento() %>
                                </p>

                                <p class="mb-0" style="flex: 1 1 150px;">
                                    <strong>Duração (hh:mm):</strong><br />
                                    <%= filme.getDuracao() %>
                                </p>

                                <p class="mb-0" style="flex: 1 1 150px;">
                                    <strong>Diretor:</strong><br />
                                    <%= filme.getDiretor() %>
                                </p>

                                <p class="mb-0" style="flex: 1 1 150px;">
                                    <strong>Gênero:</strong><br />
                                    <%= filme.getGenero() %>
                                </p>

                                <p class="mb-0" style="flex: 1 1 150px;">
                                    <strong>Idioma:</strong><br />
                                    <%= filme.getIdioma() %>
                                </p>
                                
                                 <p class="mb-0" style="flex: 1 1 150px;">
                                    <strong>Formato:</strong><br />
                                    <%= filme.getFormato() %>
                                </p>
                            </div>

                            <div class="d-flex justify-content-start mt-4">
                                <a href="/Iflix/home.jsp" class="btn btn-outline-secondary btn-lg px-6">Voltar</a>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>

<c:import url="footer.jsp" />

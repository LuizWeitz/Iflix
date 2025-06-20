<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="header.jsp"></c:import>

<main>

    <section class="vh-100 gradient-custom">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-4 col-xl-5">
                    <div class="card bg-dark text-white" style="border-radius: 1rem;">
                        <div class="card-body p-4 text-center">

                            <div class="mb-md-2 mt-md-2 pb-1">

                                <div class="mb-4">
                                    <img src="assets/iflix.svg" alt="Logo" height="70">
                                </div>

                                <form action="login" method="post">
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

                                    <button class="btn btn-outline-success btn-lg px-5"
                                        type="submit">Entrar</button>

                                </form>

                                <p class="mb-0 mt-4">
                                    Não tem uma conta? <a href="cadastroUsuario.jsp" class="text-white-50">Cadastre-se</a>
                                </p>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>

package br.edu.ifsp.arq.iflix.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.iflix.dao.FilmeDAO;
import br.edu.ifsp.arq.iflix.model.Filme;

@WebServlet("/filme/cadastro")
public class FilmeCadastrarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private FilmeDAO filmeDAO;

	public FilmeCadastrarServlet() {
		super();

		filmeDAO = FilmeDAO.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = filmeDAO.buscarTodos().size() > 0
				? filmeDAO.buscarTodos().get(filmeDAO.buscarTodos().size() - 1).getId() + 1
				: 1;

		Filme filme = new Filme(id, request.getParameter("titulo"), request.getParameter("diretor"),
				request.getParameter("anoLancamento"), request.getParameter("sinopse"), request.getParameter("idioma"),
				request.getParameter("formato"), Float.parseFloat(request.getParameter("duracao")),
				request.getParameter("linkTrailer"), request.getParameter("capa"));

		String msg = "";

		if (filmeDAO.adicionar(filme)) {
			msg = "Filme Adicionado com Sucesso!";
			
			request.setAttribute("mensagem", msg);
			request.setAttribute("classe", "alert alert-success");
			
			response.sendRedirect("home");
		} else {
			msg = "Erro ao Adicionar Filme!";
			
			request.setAttribute("mensagem", msg);
			request.setAttribute("classe", "alert alert-danger");
		}

	}
}

package br.edu.ifsp.arq.iflix.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.edu.ifsp.arq.iflix.dao.FilmeDAO;
import br.edu.ifsp.arq.iflix.model.Filme;

/**
 * Servlet implementation class BuscarFilmePorGeneroServelet
 */
@WebServlet("/buscarFilmePorGenero")
public class BuscarFilmePorGeneroServelet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private FilmeDAO filmeDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuscarFilmePorGeneroServelet() {
		super();
		filmeDAO = FilmeDAO.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String genero = request.getParameter("genero");
	
		ArrayList<Filme> filmes = filmeDAO.buscarPorGenero(genero);
		
		String json = new Gson().toJson(filmes);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
}

package br.edu.ifsp.arq.iflix.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.edu.ifsp.arq.iflix.dao.FilmeDAO;
import br.edu.ifsp.arq.iflix.model.Filme;

/**
 * Servlet implementation class BuscarFilmePorIdServelet
 */
@WebServlet("/BuscarFilmePorIdServelet")
public class BuscarFilmePorIdServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmeDAO filmeDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarFilmePorIdServelet() {
        super();
        filmeDAO = FilmeDAO.getInstance();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int id = Integer.parseInt(request.getParameter("id"));
		
		Filme filme = filmeDAO.buscarPorId(id);
		
		if (filme == null) {
			
			Map<String, String> mensagem = new HashMap<>();
			
			mensagem.put("resposta", "Filme não encontrado");
			
			String resposta = new Gson().toJson(mensagem);
			
			response.getWriter().write(resposta);
			
			return;
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().write(new Gson().toJson(filme));
	}

	
}

package br.edu.ifsp.arq.iflix.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import br.edu.ifsp.arq.iflix.dao.FilmeDAO;
import br.edu.ifsp.arq.iflix.model.Filme;

@WebServlet("/deleteFilme")
public class DeleteFilmeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FilmeDAO filmeDAO;
	public Filme filme;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteFilmeServlet() {
		super();
		filmeDAO = FilmeDAO.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));

		Map<String, String> mensagem = new HashMap<>();

		if (filmeDAO.removerPorID(id)) {
			
			mensagem.put("resposta", "Filme atualizado com sucesso");
			
		} else {
			
			mensagem.put("resposta", "Erro ao atualizar filme");
			
		}

		Gson gson = new Gson();

		response.getWriter().write(gson.toJson(mensagem));
	}
}

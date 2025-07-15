package br.edu.ifsp.arq.iflix.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.edu.ifsp.arq.iflix.dao.FilmeDAO;
import br.edu.ifsp.arq.iflix.model.Filme;

@WebServlet("/editarFilme")
public class EditarFilmeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FilmeDAO filmeDAO;

	public EditarFilmeServlet() {
		super();
		filmeDAO = FilmeDAO.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
	
		BufferedReader reader = request.getReader();
		
		Gson gson = new Gson();

		Filme filmeEditado = gson.fromJson(reader, Filme.class);

		List<Filme> filmes = filmeDAO.buscarTodos();

		boolean encontrado = false;

		for (Filme f : filmes) {
			if (f.getId() == filmeEditado.getId()) {
				encontrado = true;
				break;
			}
		}
		
		Map<String, String> mensagem = new HashMap<>();

		if (!encontrado) {
			mensagem.put("resposta", "Filme não encontrado");
			response.getWriter().write(gson.toJson(mensagem));
			return;
		}

		
		Filme novoFilme = new Filme(
			filmeEditado.getId(),
			filmeEditado.getTitulo(),
			filmeEditado.getGenero(),
			filmeEditado.getDiretor(),
			filmeEditado.getAnoLancamento(),
			filmeEditado.getSinopse(),
			filmeEditado.getIdioma(),
			filmeEditado.getFormato(),
			filmeEditado.getDuracao(),
			filmeEditado.getLinkTrailer(),
			filmeEditado.getImgCapa() 
		);
		
	
		if (filmeDAO.atualizar(novoFilme)) {
			
			mensagem.put("resposta", "Filme atualizado com sucesso");
			
		} else {
			
			mensagem.put("resposta", "Erro: o filme não pôde ser atualizado");
			
		}

		response.getWriter().write(gson.toJson(mensagem));
	}
}

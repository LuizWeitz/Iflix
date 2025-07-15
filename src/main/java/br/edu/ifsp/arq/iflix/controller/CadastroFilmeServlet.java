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

@WebServlet("/cadastroFilme")
public class CadastroFilmeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private FilmeDAO filmeDAO;

	public CadastroFilmeServlet() {
		super();
		filmeDAO = FilmeDAO.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		BufferedReader reader = request.getReader();
		
		Gson gson = new Gson();

		Filme novoFilme = gson.fromJson(reader, Filme.class);

		List<Filme> filmes = filmeDAO.buscarTodos();
		
		int id = filmes.size() > 0
				? filmes.get(filmes.size() - 1).getId() + 1
				: 1;


		Filme filme = new Filme(
			id,
			novoFilme.getTitulo(),
			novoFilme.getGenero(),
			novoFilme.getDiretor(),
			novoFilme.getAnoLancamento(),
			novoFilme.getSinopse(),
			novoFilme.getIdioma(),
			novoFilme.getFormato(),
			novoFilme.getDuracao(),
			novoFilme.getLinkTrailer(),
			novoFilme.getImgCapa() 
		);

		Map<String, String> mensagem = new HashMap<>();

		if (filmeDAO.adicionar(filme)) {
			
			mensagem.put("resposta", "Filme cadastrado com sucesso");
			
		} else {
			
			mensagem.put("resposta", "Erro ao cadastrar filme");
		}

		
        String respostaJson = gson.toJson(mensagem);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(respostaJson);
	}
}

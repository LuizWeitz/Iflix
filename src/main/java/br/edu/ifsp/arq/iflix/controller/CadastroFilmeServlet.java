package br.edu.ifsp.arq.iflix.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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

		Part filePart = request.getPart("imgCapa");

		InputStream fileContent = filePart.getInputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		byte[] buffer = new byte[1024];

		int bytesRead;

		while ((bytesRead = fileContent.read(buffer)) != -1) {
			baos.write(buffer, 0, bytesRead);
		}

		byte[] fileBytes = baos.toByteArray();

		String base64String = Base64.getEncoder().encodeToString(fileBytes);

		int id = filmeDAO.buscarTodos().size() > 0
				? filmeDAO.buscarTodos().get(filmeDAO.buscarTodos().size() - 1).getId() + 1
				: 1;

		Filme filme = new Filme(id, request.getParameter("titulo"), request.getParameter("diretor"),
				request.getParameter("anoLancamento"), request.getParameter("sinopse"), request.getParameter("idioma"),
				request.getParameter("formato"), Float.parseFloat(request.getParameter("duracao")),
				request.getParameter("linkTrailer"), base64String);

		String msg = "";

		if (filmeDAO.adicionar(filme)) {
			msg = "Filme Adicionado com Sucesso!";

			request.setAttribute("mensagem", msg);
			request.setAttribute("classe", "alert alert-success");

			getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
		} else {
			msg = "Erro ao Adicionar Filme!";

			request.setAttribute("mensagem", msg);
			request.setAttribute("classe", "alert alert-danger");

			getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
		}

	}
}

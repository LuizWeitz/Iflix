package br.edu.ifsp.arq.iflix.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.edu.ifsp.arq.iflix.dao.FilmeDAO;
import br.edu.ifsp.arq.iflix.model.Filme;

@WebServlet("/cadastroFilme")
@MultipartConfig
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

		Part filePart = request.getPart("capaFile");

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

		Filme filme = new Filme(id, request.getParameter("titulo"), request.getParameter("genero"), request.getParameter("diretor"),
				request.getParameter("anoLancamento"), request.getParameter("sinopse"), request.getParameter("idioma"),
				request.getParameter("formato"), request.getParameter("duracao"),
				request.getParameter("linkTrailer"), base64String);

		if (filmeDAO.adicionar(filme)) {
			response.sendRedirect("home.jsp");
		} else {
			response.sendRedirect("erroProcessarSolicitacao.jsp");
		}

	}
}

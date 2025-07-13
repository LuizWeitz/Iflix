package br.edu.ifsp.arq.iflix.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import br.edu.ifsp.arq.iflix.dao.FilmeDAO;
import br.edu.ifsp.arq.iflix.model.Filme;
import br.edu.ifsp.arq.iflix.model.Usuario;

/**
 * Servlet implementation class EditarFilmeServlet
 */
@WebServlet("/editarFilme")
@MultipartConfig
public class EditarFilmeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FilmeDAO filmeDAO;
	public Filme filme;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarFilmeServlet() {
		super();
		filmeDAO = FilmeDAO.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		filme = filmeDAO.buscarPorId(id);

		request.setAttribute("filme", filme);

		Usuario usuario = null;

		HttpSession session = request.getSession();

		if (session != null) {
			usuario = (Usuario) session.getAttribute("usuario");
		}

		if (usuario == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("verFilme.jsp");

			dispatcher.forward(request, response);
			return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("gerenciamentoFilme.jsp");

		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		try {

			int id = Integer.parseInt(request.getParameter("id"));

			Filme filmeExistente = filmeDAO.buscarPorId(id);

			if (filmeExistente == null) {

				response.sendRedirect("erroProcessarSolicitacao.jsp");
				return;

			}

			String titulo = request.getParameter("titulo");
			String genero = request.getParameter("genero");
			String diretor = request.getParameter("diretor");
			String anoLancamento = request.getParameter("anoLancamento");
			String sinopse = request.getParameter("sinopse");
			String idioma = request.getParameter("idioma");
			String formato = request.getParameter("formato");
			String duracao = request.getParameter("duracao");
			String linkTrailer = request.getParameter("linkTrailer");

			Part filePart = request.getPart("capaFile");
			String base64Capa = filmeExistente.getImgCapa();

			if (filePart != null && filePart.getSize() > 0) {
				try (InputStream fileContent = filePart.getInputStream();
						ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

					byte[] buffer = new byte[1024];
					int bytesRead;

					while ((bytesRead = fileContent.read(buffer)) != -1) {
						baos.write(buffer, 0, bytesRead);
					}

					byte[] fileBytes = baos.toByteArray();
					base64Capa = Base64.getEncoder().encodeToString(fileBytes);
				}
			}

			Filme filmeAtualizado = new Filme(id, titulo, genero, diretor, anoLancamento, sinopse, idioma, formato,
					duracao, linkTrailer, base64Capa);

			filmeDAO.atualizar(filmeAtualizado);

			response.sendRedirect("home.jsp");

		} catch (Exception e) {
			response.sendRedirect("erroProcessarSolicitacao.jsp");

		}

	}

}

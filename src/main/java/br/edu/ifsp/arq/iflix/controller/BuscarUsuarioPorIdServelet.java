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

import br.edu.ifsp.arq.iflix.dao.UsuarioDAO;
import br.edu.ifsp.arq.iflix.model.Usuario;

/**
 * Servlet implementation class BuscarUsuarioPorIdServelet
 */
@WebServlet("/BuscarUsuarioPorIdServelet")
public class BuscarUsuarioPorIdServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO usuarioDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuscarUsuarioPorIdServelet() {
		super();
		usuarioDAO = UsuarioDAO.getInstance();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Usuario usuario = usuarioDAO.buscarPorId(id);

		if (usuario == null) {
			Map<String, String> mensagem = new HashMap<>();

			mensagem.put("resposta", "Usuário não encontrado");

			String resposta = new Gson().toJson(mensagem);

			response.getWriter().write(resposta);

			return;
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().write(new Gson().toJson(usuario));
	}

}

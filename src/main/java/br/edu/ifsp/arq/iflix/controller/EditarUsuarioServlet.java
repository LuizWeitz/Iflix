package br.edu.ifsp.arq.iflix.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.edu.ifsp.arq.iflix.dao.UsuarioDAO;
import br.edu.ifsp.arq.iflix.model.Usuario;
import br.edu.ifsp.arq.iflix.model.UsuarioTipo;

/**
 * Servlet implementation class EditarUsuarioServlet
 */
@WebServlet("/editarUsuario")
@MultipartConfig
public class EditarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO usuarioDAO;
	public Usuario usuario;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarUsuarioServlet() {
		super();
		usuarioDAO = UsuarioDAO.getInstance();
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// Leitura do corpo da req como texto
		BufferedReader reader = request.getReader();

		Gson gson = new Gson();

		// Converte a req de json para a class usuario
		Usuario editarUsuario = gson.fromJson(reader, Usuario.class);

		List<Usuario> usuarios = (List<Usuario>) usuarioDAO.buscarTodos();

		Map<String, String> mensagem = new HashMap<String, String>();

		for (Usuario usuario : usuarios) {
			if (usuario.getId() == editarUsuario.getId()) {
				continue;
			} else {
				
				mensagem.put("resposta", "Usuário não encontrado");

				String resposta = new Gson().toJson(mensagem);

				response.getWriter().write(resposta);
				
				response.setStatus(404);
			
				return;
			}
		}

		Usuario usuario = new Usuario(editarUsuario.getId(), editarUsuario.getNome(), editarUsuario.getDataNasc(),
				editarUsuario.getEmail(), editarUsuario.getSenha(), editarUsuario.getImgPerfil(), UsuarioTipo.ADMIN);

		if (usuarioDAO.atualizar(usuario)) {

			mensagem.put("resposta", "Usuário editado com sucesso");

		} else {

			mensagem.put("resposta", "Erro, o usuário não pode ser atualizado");
		}

		String respostaJson = gson.toJson(mensagem);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(respostaJson);
	}

}

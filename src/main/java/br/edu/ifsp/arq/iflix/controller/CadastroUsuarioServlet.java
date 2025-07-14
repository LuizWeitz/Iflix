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

@WebServlet("/cadastroUsuario")
@MultipartConfig
public class CadastroUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UsuarioDAO usuarioDAO;

	public CadastroUsuarioServlet() {
		super();
		usuarioDAO = UsuarioDAO.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 request.setCharacterEncoding("UTF-8");
		
		 // Leitura do corpo da req como texto
	     BufferedReader reader = request.getReader();
	     
	     Gson gson = new Gson();
	     
	     // Converte a req de json para a class usuario
	     Usuario novoUsuario = gson.fromJson(reader, Usuario.class);

		 List<Usuario> usuarios = (List<Usuario>) usuarioDAO.buscarTodos();
		 
		 Map<String, String> mensagem = new HashMap<String, String>();

		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(novoUsuario.getEmail())) {

				mensagem.put("resposta", "Usuário com email já cadastrado");
				return;
			}
		}

		int id = usuarioDAO.buscarTodos().size() > 0
			    ? usuarioDAO.buscarTodos().get(usuarioDAO.buscarTodos().size() - 1).getId() + 1
			    : 1;  

		Usuario usuario = new Usuario(id, novoUsuario.getNome(), 
				novoUsuario.getDataNasc(), novoUsuario.getEmail(), novoUsuario.getSenha(), novoUsuario.getImgPerfil(), UsuarioTipo.admin);

		if (usuarioDAO.adicionar(usuario)) {

			mensagem.put("resposta", "Usuário adicionado com sucesso");

		} else {

			mensagem.put("resposta", "Erro, o usuário não pode ser adicionada");	
		}
		
        String respostaJson = gson.toJson(mensagem);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(respostaJson);

	}

}

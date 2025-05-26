package br.edu.ifsp.arq.iflix.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import br.edu.ifsp.arq.iflix.dao.UsuarioDAO;
import br.edu.ifsp.arq.iflix.model.Usuario;

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
		
		String msg = "";

		List<Usuario> usuarios = (List<Usuario>) usuarioDAO.buscarTodos();

		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(request.getParameter("email"))) {
			
				msg = "Email Já Cadastrado!";

				 msg = "Email Já Cadastrado!";
				request.setAttribute("mensagem", msg);
				request.setAttribute("classe", "alert alert-success");
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

	
				return;
			}
		}

		Part filePart = request.getPart("imgPerfil");

		InputStream fileContent = filePart.getInputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		byte[] buffer = new byte[1024];

		int bytesRead;

		while ((bytesRead = fileContent.read(buffer)) != -1) {
			baos.write(buffer, 0, bytesRead);
		}

		byte[] fileBytes = baos.toByteArray();

		String base64String = Base64.getEncoder().encodeToString(fileBytes);

		int id = usuarioDAO.buscarTodos().size() > 0
				? usuarioDAO.buscarTodos().get(usuarioDAO.buscarTodos().size() - 1).getId() + 1
				: 1;

		String nome = request.getParameter("nome");
		String dataNasc = request.getParameter("dataNascimento");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usuario = new Usuario(id, nome, dataNasc, email, senha, base64String);



		if (usuarioDAO.adicionar(usuario)) {

			HttpSession session = request.getSession();

			session.setAttribute("usuario", usuario);

			msg = "Bem-Vindo ao IFLIX!";

			request.setAttribute("mensagem", msg);
			request.setAttribute("classe", "alert alert-success");

			response.sendRedirect("home.jsp");

		} else {

			msg = "Erro ao Adicionar Usuario!";

			request.setAttribute("mensagem", msg);
			request.setAttribute("classe", "alert alert-success");

			response.sendRedirect("index.jsp");
		}

	}

}

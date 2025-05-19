package br.edu.ifsp.arq.iflix.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifsp.arq.iflix.dao.UsuarioDAO;
import br.edu.ifsp.arq.iflix.model.Usuario;

@WebServlet("/cadUsuario")
public class CadUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UsuarioDAO usuarioDAO;

	public CadUsuarioServlet() {
		super();
		usuarioDAO = UsuarioDAO.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = usuarioDAO.buscarTodos().size() > 0
				? usuarioDAO.buscarTodos().get(usuarioDAO.buscarTodos().size() - 1).getId() + 1
				: 1;

		Usuario usuario = new Usuario(id, request.getParameter("nome"), request.getParameter("dataNasc"),
				request.getParameter("email"), request.getParameter("senha"), request.getParameter("imgPerfil"));

		if (usuarioDAO.adicionar(usuario)) {

			// manda mensagem de sucesso
		
			HttpSession session = request.getSession();
			
			session.setAttribute("usuario", usuario);
			
			response.sendRedirect("home");

		} else {

			// manda mensagem de erro

		}

	}
}

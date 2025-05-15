package br.edu.ifsp.arq.iflix.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifsp.arq.iflix.model.Usuario;

@WebServlet("/cadUsuario")
public class CadUsuario extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		if (getServletContext().getAttribute("cadastro") == null) {
			getServletContext().setAttribute("cadastro", new ArrayList<Usuario>());
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String dataNasc = request.getParameter("dataNasc");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String imgPerfil = request.getParameter("imgPerfil");

		List<Usuario> usuarios = (List<Usuario>) getServletContext().getAttribute("cadastro");

		int novoId = usuarios.size() > 0 ? usuarios.get(usuarios.size() - 1).getId() + 1 : 1;

		Usuario usuario = new Usuario(novoId, nome, dataNasc, email, senha, imgPerfil);
		usuarios.add(usuario);

		HttpSession session = request.getSession();
		session.setAttribute("usuario", usuario);

		response.sendRedirect("home");
	}
}

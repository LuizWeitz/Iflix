package br.edu.ifsp.arq.iflix.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.iflix.dao.UsuarioDAO;
import br.edu.ifsp.arq.iflix.model.Usuario;

/**
 * Servlet implementation class EditarUsuario
 */
@WebServlet("/editarUsuario")
public class EditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO usuarioDAO;
	public Usuario usuario;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarUsuario() {
        super();
        usuarioDAO = UsuarioDAO.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 int id = Integer.parseInt(request.getParameter("id"));
		 
		 usuario = usuarioDAO.buscarPorId(id);
		 
		 request.setAttribute("usuario", usuario);
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
	      dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int id = Integer.parseInt(request.getParameter("id"));
	    String nome = request.getParameter("nome");
	    String dataNasc = request.getParameter("dataNasc");
	    String email = request.getParameter("email");
	    String senha = request.getParameter("senha");

	    Usuario usuario = new Usuario(id, nome, dataNasc, email, senha, senha);

	    usuarioDAO.atualizar(usuario); 

	    request.setAttribute("usuario", usuario);
	    request.getRequestDispatcher("usuario.jsp").forward(request, response);
	}


}

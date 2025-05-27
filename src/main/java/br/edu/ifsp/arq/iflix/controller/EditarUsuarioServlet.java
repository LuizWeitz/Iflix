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
import javax.servlet.http.Part;

import br.edu.ifsp.arq.iflix.dao.UsuarioDAO;
import br.edu.ifsp.arq.iflix.model.Usuario;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 int id = Integer.parseInt(request.getParameter("id"));
		 
		 usuario = usuarioDAO.buscarPorId(id);
		 
		 request.setAttribute("usuario", usuario);
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("gerenciamentoUsuario.jsp");
		 
	     dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		 request.setCharacterEncoding("UTF-8");
		
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
		
		
		int id = Integer.parseInt(request.getParameter("id"));
	    String nome = request.getParameter("nome");
	    String dataNasc = request.getParameter("dataNasc");
	    String email = request.getParameter("email");
	    String senha = request.getParameter("senha");

	    Usuario usuario = new Usuario(id, nome, dataNasc, email, senha, base64String);

	    usuarioDAO.atualizar(usuario); 
	    
		response.sendRedirect("home.jsp");
	}

}

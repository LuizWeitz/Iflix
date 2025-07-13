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

@WebServlet("/login")
public class LoginUsuarioServelet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	private UsuarioDAO usuarioDAO;
	public Usuario usuario;
	
	   /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUsuarioServelet() {
        super();
        usuarioDAO = UsuarioDAO.getInstance();
    }


	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		 request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        for (Usuario usuario : usuarioDAO.buscarTodos()) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
               
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                
                response.sendRedirect("home.jsp");
                return;
            } 
        } 
        
   
       	 response.sendRedirect("erroLogin.jsp");
    
       
    }
}

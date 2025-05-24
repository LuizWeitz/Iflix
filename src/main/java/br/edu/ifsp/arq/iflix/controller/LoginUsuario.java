package br.edu.ifsp.arq.iflix.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifsp.arq.iflix.model.Usuario;

@WebServlet("/login")
public class LoginUsuario extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        boolean usuarioErro = false;

        List<Usuario> usuarios = (List<Usuario>) getServletContext().getAttribute("usuarios");

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
               
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                
                response.sendRedirect("home");
                return;
            }
        } 
        
        usuarioErro = true;
       
    }
}

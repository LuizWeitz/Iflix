package br.edu.ifsp.arq.iflix.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import br.edu.ifsp.arq.iflix.dao.UsuarioDAO;
import br.edu.ifsp.arq.iflix.model.Usuario;

@WebServlet("/deleteUsuario")
public class DeleteUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
	
	private UsuarioDAO usuarioDAO;
	public Usuario usuario;

	 /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUsuarioServlet() {
        super();
        usuarioDAO = UsuarioDAO.getInstance();
    }

	
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

        if (usuarioDAO.removerPorID(id)) {
        	
        	 HttpSession session = request.getSession();
    		 
    		 session.invalidate();
     
             response.sendRedirect("index.jsp");
             
        } else {
        	
            response.sendRedirect("erroProcessarSolicitacao.jsp");
        }
    }
}

package br.edu.ifsp.arq.iflix.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

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
		
    	response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        Map<String, String> mensagem = new HashMap<String, String>();
        
        for (Usuario usuario : usuarioDAO.buscarTodos()) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
            	
            	mensagem.put("resposta", "Usuário autenticado");
            	mensagem.put("user_id", Integer.toString(usuario.getId())); 
            	mensagem.put("user_nome", usuario.getNome()); 

        		String json = new Gson().toJson(mensagem);
        		
        	
        		response.getWriter().write(json);
            	
                return;
            } 
        }
        
    	mensagem.put("resposta", "Erro ao autenticar usuário");	
    	
		String json = new Gson().toJson(mensagem);
		
		response.getWriter().write(json);
    	
        return;
        
    }
}
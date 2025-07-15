package br.edu.ifsp.arq.iflix.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import br.edu.ifsp.arq.iflix.dao.UsuarioDAO;

@WebServlet("/deleteUsuario")
public class DeleteUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
	
	private UsuarioDAO usuarioDAO;

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
		
		Map<String, String> mensagem = new HashMap<>();

		if (usuarioDAO.removerPorID(id)) {
			
			mensagem.put("resposta", "Usuário removido com sucesso");
			
		} else {
			
			mensagem.put("resposta", "Erro ao remover usuário");
			
		}
		
		Gson gson = new Gson();

		response.getWriter().write(gson.toJson(mensagem));
    }
}

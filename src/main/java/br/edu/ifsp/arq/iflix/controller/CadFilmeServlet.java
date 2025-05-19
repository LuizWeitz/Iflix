package br.edu.ifsp.arq.iflix.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.iflix.dao.FilmeDAO;
import br.edu.ifsp.arq.iflix.model.Filme;

@WebServlet("/CadFilmeServlet")
public class CadFilmeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private FilmeDAO filmeDAO;
       
    public CadFilmeServlet() {
        super();
        
        filmeDAO = FilmeDAO.getInstance();
 
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = filmeDAO.buscarTodos().size() > 0
				? filmeDAO.buscarTodos().get(filmeDAO.buscarTodos().size() - 1).getId() + 1
				: 1;
		
		Filme filme = new Filme(id, 
				getServletInfo(), getServletInfo(), 
				getServletInfo(), getServletInfo(), 
				getServletInfo(), getServletInfo(), 
				id, getServletName(), getServletInfo());
		
		if(filmeDAO.adicionar(filme)) {
			// manda mensagem de sucesso
			response.sendRedirect("home");
		} else {
			// manda mensagem de erro
		}

	}
}

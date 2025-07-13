package br.edu.ifsp.arq.iflix.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;

import br.edu.ifsp.arq.iflix.dao.FilmeDAO;
import br.edu.ifsp.arq.iflix.model.Filme;


@WebServlet("/deleteFilme")
public class DeleteFilmeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
	
	private FilmeDAO filmeDAO;
	public Filme filme;

	 /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFilmeServlet() {
        super();
        filmeDAO = FilmeDAO.getInstance();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

        if (filmeDAO.deletarPorID(id)) {
        	
             response.sendRedirect("home.jsp");
             
        } else {
        	
            response.sendRedirect("erroProcessarSolicitacao.jsp");
        }
    }
}

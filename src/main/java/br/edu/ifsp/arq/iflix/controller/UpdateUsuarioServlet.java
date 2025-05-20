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

@WebServlet("/atualizarUsuario")
public class UpdateUsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;

    public UpdateUsuarioServlet() {
        super();
        usuarioDAO = UsuarioDAO.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       int id = Integer.parseInt(request.getParameter("id"));

        Usuario usuarioExistente = usuarioDAO.buscarPorId(id);

        if (usuarioExistente != null) {

            usuarioExistente.setNome(request.getParameter("nome"));
            usuarioExistente.setDataNasc(request.getParameter("dataNasc"));
            usuarioExistente.setEmail(request.getParameter("email"));
            usuarioExistente.setSenha(request.getParameter("senha"));
            usuarioExistente.setImgPerfil(request.getParameter("imgPerfil"));

            if (usuarioDAO.atualizar(usuarioExistente)) {

                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuarioExistente);

                response.sendRedirect("home");

            } else {
                request.setAttribute("mensagemErro", "Erro ao atualizar os dados.");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }

        } else {
            request.setAttribute("mensagemErro", "Usuário não encontrado.");
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }
}

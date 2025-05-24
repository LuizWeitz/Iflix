package br.edu.ifsp.arq.iflix.controller;

import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import br.edu.ifsp.arq.iflix.dao.UsuarioDAO;
import br.edu.ifsp.arq.iflix.model.Usuario;

@WebServlet("/cadUsuario")
@MultipartConfig
public class CadUsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UsuarioDAO usuarioDAO;

    public CadUsuarioServlet() {
        super();
        usuarioDAO = UsuarioDAO.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String dataNasc = request.getParameter("dataNascimento");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        Part arquivoPart = request.getPart("imgPerfil");

        String nomeArquivo = Paths.get(arquivoPart.getSubmittedFileName()).getFileName().toString();

        String caminhoUpload = getServletContext().getRealPath("") + "uploads";

        java.io.File uploadDir = new java.io.File(caminhoUpload);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        arquivoPart.write(caminhoUpload + java.io.File.separator + nomeArquivo);

        int id = usuarioDAO.buscarTodos().size() > 0
                ? usuarioDAO.buscarTodos().get(usuarioDAO.buscarTodos().size() - 1).getId() + 1
                : 1;

        Usuario usuario = new Usuario(id, nome, dataNasc, email, senha, nomeArquivo);

        if (usuarioDAO.adicionar(usuario)) {

            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);

            response.sendRedirect("home");

        } else {
            response.getWriter().println("Erro ao cadastrar usuário.");
        }

    }

}

package br.edu.ifsp.arq.iflix.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import br.edu.ifsp.arq.iflix.model.Usuario;

@WebServlet("/deleteUsuario")
public class DeleteUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String idParam = request.getParameter("id");

        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                List<Usuario> usuarios = (List<Usuario>) getServletContext().getAttribute("usuarios");

                if (usuarios != null) {
                    usuarios.removeIf(usuario -> usuario.getId() == id);
                }

                response.sendRedirect("listar-usuarios.jsp");
            } catch (NumberFormatException e) {
                response.sendRedirect("listar-usuarios.jsp?msg=erro_id_invalido");
            }
        } else {
            response.sendRedirect("listar-usuarios.jsp?msg=falta_id");
        }
    }
}

package br.edu.ifsp.arq.iflix.dao;

import br.edu.ifsp.arq.iflix.model.Usuario;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsuarioDAO {

    private static UsuarioDAO instance;
    private final String arquivoUsuarios = "src/main/webapp/data/usuarios.json";

    private UsuarioDAO() {}

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }

    private boolean salvarArquivo(List<Usuario> usuarios) {
        Gson gson = new Gson();
        try (FileWriter fileWriter = new FileWriter(arquivoUsuarios, StandardCharsets.UTF_8)) {
            gson.toJson(usuarios, fileWriter);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Usuario> buscarTodos() {
        File arquivo = new File(arquivoUsuarios);
        if (!arquivo.exists()) {
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(arquivo, StandardCharsets.UTF_8)) {
            Gson gson = new Gson();
            Usuario[] usuariosArray = gson.fromJson(reader, Usuario[].class);
            if (usuariosArray == null) {
                return new ArrayList<>();
            }
            return new ArrayList<>(Arrays.asList(usuariosArray));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public boolean adicionar(Usuario usuario) {
        List<Usuario> usuarios = buscarTodos();
        usuarios.add(usuario);
        return salvarArquivo(usuarios);
    }

    public boolean atualizar(Usuario usuarioAtualizado) {
        List<Usuario> usuarios = buscarTodos();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuarioAtualizado.getId()) {
                usuarios.set(i, usuarioAtualizado);
                return salvarArquivo(usuarios);
            }
        }
        return false;
    }

    public boolean removerPorID(int id) {
        List<Usuario> usuarios = buscarTodos();
        boolean removido = usuarios.removeIf(u -> u.getId() == id);
        if (removido) {
            return salvarArquivo(usuarios);
        }
        return false;
    }

    public Usuario buscarPorId(int id) {
        for (Usuario usuario : buscarTodos()) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
}

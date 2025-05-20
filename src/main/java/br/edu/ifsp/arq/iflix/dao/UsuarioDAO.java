package br.edu.ifsp.arq.iflix.dao;

import java.util.ArrayList;
import java.util.Iterator;
import br.edu.ifsp.arq.iflix.model.Usuario;

public class UsuarioDAO {
    
    private static UsuarioDAO instance;
    
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    
    private UsuarioDAO() {
        this.usuarios = new ArrayList<Usuario>();
    }
    
    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }
    
    public boolean adicionar(Usuario usuario) {
        return this.usuarios.add(usuario);
    }
    
    public ArrayList<Usuario> buscarTodos() {
        return this.usuarios;
    }
    
    public boolean deletarPorID(int id) {
        Iterator<Usuario> iterator = usuarios.iterator();
        while (iterator.hasNext()) {
            Usuario usuario = iterator.next();
            if (usuario.getId() == id) {
                iterator.remove();
                return true; 
            }
        }
        return false; 
    }

    public boolean remover(int id) {
        return deletarPorID(id);
    }

    public boolean atualizar(Usuario usuarioExistente) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getId() == usuarioExistente.getId()) {
                usuarios.set(i, usuarioExistente); 
                return true; 
            }
        }
        return false; 
    }

    public Usuario buscarPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;  
            }
        }
        return null;  
        
    }

}

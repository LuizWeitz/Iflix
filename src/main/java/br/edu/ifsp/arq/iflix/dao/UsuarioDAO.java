package br.edu.ifsp.arq.iflix.dao;

import br.edu.ifsp.arq.iflix.model.Usuario;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;

public class UsuarioDAO {

	private static UsuarioDAO instance;

	private UsuarioDAO() {
	}

	public static UsuarioDAO getInstance() {

		if (instance == null) {
			instance = new UsuarioDAO();
		}

		return instance;
	}
	
	private String filePathDataUsuarios = "data/usuarios.json";

	private boolean salvarArquivo(ArrayList<Usuario> usuarios) {

		Gson gson = new Gson();

		try {

			FileWriter fileWriter = new FileWriter(filePathDataUsuarios, StandardCharsets.UTF_8, false);

			PrintWriter pw = new PrintWriter(fileWriter);

			String json = gson.toJson(usuarios);
			
			pw.println(json);

			pw.close();
			
			fileWriter.close();

			return true;
		
		} catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}

	}

	public boolean adicionar(Usuario usuario) {

		ArrayList<Usuario> usuarios = buscarTodos();
		if (usuarios == null) {
			usuarios = new ArrayList<>();
		}

		usuarios.add(usuario);
		return salvarArquivo(usuarios);

	}

	public ArrayList<Usuario> buscarTodos() {

		File file = new File(filePathDataUsuarios);
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		Gson gson = new Gson();
		
		 try {
		        FileReader fileReader = new FileReader(file);
		        usuarios = gson.fromJson(fileReader, new com.google.gson.reflect.TypeToken<ArrayList<Usuario>>(){}.getType());
		        fileReader.close();

		        if (usuarios == null) {
		        	usuarios = new ArrayList<>();
		        }

		    } catch (IOException e) {
		        e.printStackTrace();
		    }

		    return usuarios;

	
	}

	public boolean removerPorID(int id) {
		ArrayList<Usuario> usuarios = buscarTodos();
		boolean removido = false;
		

		Iterator<Usuario> iterator = usuarios.iterator();
		
		while (iterator.hasNext()) {
			Usuario usuario = iterator.next();
			if (usuario.getId() == id) {
				iterator.remove();
				removido = true;
				break;
			}
		}

		if (removido) {
			return salvarArquivo(usuarios);
		}

		return false;
	}

	public boolean atualizar(Usuario usuarioExistente) {

		ArrayList<Usuario> usuarios = buscarTodos();

		if (usuarios == null)
			return false;

		for (int i = 0; i < usuarios.size(); i++) {
			Usuario usuario = usuarios.get(i);

			if (usuario.getId() == usuarioExistente.getId()) {
				usuarios.set(i, usuarioExistente);
				break;
			}
		}

		salvarArquivo(usuarios);

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

package br.edu.ifsp.arq.iflix.dao;
import br.edu.ifsp.arq.iflix.model.Usuario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

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

	private boolean salvarArquivo(ArrayList<Usuario> usuarios) {

		Gson gson = new Gson();

		try {

			FileWriter fileWriter = new FileWriter("src/main/webapp/data/usuarios.json", StandardCharsets.UTF_8, true);

			PrintWriter pw = new PrintWriter(fileWriter);

			for (Usuario usuario : usuarios) {

				String json = gson.toJson(usuario);

				pw.println(gson.toJson(json));
			}

			pw.close();

			fileWriter.close();

			return true;

		} catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}

	}

	public boolean adicionar(Usuario usuario) {

		Gson gson = new Gson();

		try {

			FileWriter fileWriter = new FileWriter("src/main/webapp/data/usuarios.json", StandardCharsets.UTF_8, true);

			PrintWriter pw = new PrintWriter(fileWriter);

			String json = gson.toJson(usuario);

			pw.println(json);

			pw.close();

			fileWriter.close();

		} catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}

		return true;

	}

	public ArrayList<Usuario> buscarTodos() {

		File file = new File("src/main/webapp/data/usuarios.json");

		try {

			Gson gson = new Gson();

			FileReader fileReader;

			fileReader = new FileReader(file);

			Scanner scanner = new Scanner(fileReader);

			ArrayList<Usuario> lista;

			lista = new ArrayList<Usuario>();

			while (scanner.hasNextLine()) {

				String linha = scanner.nextLine();

				Usuario usuario = gson.fromJson(linha, Usuario.class);

				lista.add(usuario);

			}

			scanner.close();

			return lista;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean removerPorID(int id) {
		ArrayList<Usuario> usuarios = buscarTodos();

		if (usuarios == null)
			return false;

		for (int i = 0; i < usuarios.size(); i++) {
			Usuario usuario = usuarios.get(i);

			if (usuario.getId() == id) {
				usuarios.remove(i);
				break;
			}
		}
		
		salvarArquivo(usuarios);
		
		return true;
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

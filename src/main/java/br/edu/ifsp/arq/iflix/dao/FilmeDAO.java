package br.edu.ifsp.arq.iflix.dao;

import br.edu.ifsp.arq.iflix.model.Filme;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

public class FilmeDAO {

	private static FilmeDAO instance;

	private FilmeDAO() {
	}

	public static FilmeDAO getInstance() {
		
		if (instance == null) {
			instance = new FilmeDAO();
		}
		
		return instance;
	}

	private String filePathDataFilmes = "data/filmes.json";

	private boolean salvarArquivo(ArrayList<Filme> filmes) {
		
		Gson gson = new Gson();

		try {
			
			FileWriter fileWriter = new FileWriter(filePathDataFilmes, StandardCharsets.UTF_8, false);
			
			PrintWriter pw = new PrintWriter(fileWriter);

			String json = gson.toJson(filmes);
			
			pw.println(json);

			pw.close();
			
			fileWriter.close();

			return true;

		} catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean adicionar(Filme filme) {
		ArrayList<Filme> filmes = buscarTodos();
		if (filmes == null) {
			filmes = new ArrayList<>();
		}

		filmes.add(filme);
		return salvarArquivo(filmes);
	}

	public ArrayList<Filme> buscarTodos() {
	    File file = new File(filePathDataFilmes);
	    ArrayList<Filme> filmes = new ArrayList<>();
	    Gson gson = new Gson();

	    try {
	        FileReader fileReader = new FileReader(file);
	        filmes = gson.fromJson(fileReader, new com.google.gson.reflect.TypeToken<ArrayList<Filme>>(){}.getType());
	        fileReader.close();

	        if (filmes == null) {
	            filmes = new ArrayList<>();
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return filmes;
	}

	public ArrayList<Filme> buscarPorGenero(String genero) {
		ArrayList<Filme> resultado = new ArrayList<>();

		for (Filme filme : buscarTodos()) {
			if (filme.getGenero().toString().equalsIgnoreCase(genero)) {
				resultado.add(filme);
			}
		}

		return resultado;
	}

	public boolean removerPorID(int id) {
		ArrayList<Filme> filmes = buscarTodos();
		boolean removido = false;

		Iterator<Filme> iterator = filmes.iterator();
		
		while (iterator.hasNext()) {
			Filme filme = iterator.next();
			if (filme.getId() == id) {
				iterator.remove();
				removido = true;
				break;
			}
		}

		if (removido) {
			return salvarArquivo(filmes);
		}

		return false;
	}

	public boolean atualizar(Filme filmeAtualizado) {
		ArrayList<Filme> filmes = buscarTodos();

		for (int i = 0; i < filmes.size(); i++) {
			Filme filme = filmes.get(i);
			if (filme.getId() == filmeAtualizado.getId()) {

				filmes.set(i, filmeAtualizado);

				break; 
			}
		}
		
		salvarArquivo(filmes);

		return false;
	}

	public Filme buscarPorId(int id) {
		for (Filme filme : buscarTodos()) {
			if (filme.getId() == id) {
				return filme;
			}
		}
		return null;
	}
}

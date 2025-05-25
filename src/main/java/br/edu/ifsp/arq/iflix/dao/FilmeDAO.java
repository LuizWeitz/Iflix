package br.edu.ifsp.arq.iflix.dao;

import java.util.ArrayList;
import java.util.Iterator;

import br.edu.ifsp.arq.iflix.model.Filme;

public class FilmeDAO {

	private static FilmeDAO instance;

	private ArrayList<Filme> filmes = new ArrayList<Filme>();

	public FilmeDAO() {
		this.filmes = new ArrayList<Filme>();
	}

	public static FilmeDAO getInstance() {
		
		if (instance == null) {
			instance = new FilmeDAO();
		}

		return instance;
	}

	public boolean adicionar(Filme filme) {
		return this.filmes.add(filme);
	}

	public ArrayList<Filme> buscarTodos() {
		return this.filmes;
	}

	public Filme buscarPorTitulo(String titulo) {
		for (Filme filme : filmes) {
			if (filme.getTitulo().equalsIgnoreCase(titulo)) {
				return filme;
			}
		}
		return null;
	}

	public boolean deletarPorID(int id) {
		Iterator<Filme> iterator = filmes.iterator();

		while (iterator.hasNext()) {
			Filme filme = iterator.next();
			if (filme.getId() == id) {
				iterator.remove();
				return true;
			}
		}
		return false;

	}

}

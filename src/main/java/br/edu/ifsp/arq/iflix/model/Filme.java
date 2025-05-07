package br.edu.ifsp.arq.iflix.model;

import java.io.Serializable;

public class Filme implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String titulo;
	private String diretor;
	private String anoLancamento;
	private String sinopse;
	private String idioma;
	private String formato;
	private float duracao;
	private String linkTrailer;
	private String capa;
	
	public Filme(int id, String titulo, String diretor, String anoLancamento, String sinopse, String idioma,
			String formato, float duracao, String linkTrailer, String capa) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.diretor = diretor;
		this.anoLancamento = anoLancamento;
		this.sinopse = sinopse;
		this.idioma = idioma;
		this.formato = formato;
		this.duracao = duracao;
		this.linkTrailer = linkTrailer;
		this.capa = capa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public float getDuracao() {
		return duracao;
	}

	public void setDuracao(float duracao) {
		this.duracao = duracao;
	}
	
	public String getLinkTrailer() {
		return linkTrailer;
	}

	public void setLinkTrailer(String linkTrailer) {
		this.linkTrailer = linkTrailer;
	}

	public String getCapa() {
		return capa;
	}

	public void setCapa(String capa) {
		this.capa = capa;
	}

}

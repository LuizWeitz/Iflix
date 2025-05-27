package br.edu.ifsp.arq.iflix.model;

import java.io.Serializable;

public class Filme implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String titulo;
	private String genero;
	private String diretor;
	private String anoLancamento;
	private String sinopse;
	private String idioma;
	private String formato;
	private String duracao;
	private String linkTrailer;
	private String imgCapa;
	
	public Filme(int id, String titulo, String genero, String diretor, String anoLancamento, String sinopse, String idioma,
			String formato, String duracao, String linkTrailer, String imgCapa) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.diretor = diretor;
		this.anoLancamento = anoLancamento;
		this.sinopse = sinopse;
		this.idioma = idioma;
		this.formato = formato;
		this.duracao = duracao;
		this.linkTrailer = linkTrailer;
		this.imgCapa = imgCapa;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
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

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	
	public String getLinkTrailer() {
		return linkTrailer;
	}

	public void setLinkTrailer(String linkTrailer) {
		this.linkTrailer = linkTrailer;
	}

	public String getImgCapa() {
		return imgCapa;
	}

	public void setImgCapa(String imgCapa) {
		this.imgCapa = imgCapa;
	}
	
	@Override
	public String toString() {
	    return "Filme{" +
	            "id=" + id +
	            ", titulo='" + titulo + '\'' +
	            ", genero='" + genero + '\'' +
	            ", diretor='" + diretor + '\'' +
	            ", anoLancamento='" + anoLancamento + '\'' +
	            ", sinopse='" + sinopse + '\'' +
	            ", idioma='" + idioma + '\'' +
	            ", formato='" + formato + '\'' +
	            ", duracao='" + duracao + '\'' +
	            ", linkTrailer='" + linkTrailer + '\'' +
	            ", imgCapa='" + imgCapa + '\'' +
	            '}';
	}


}

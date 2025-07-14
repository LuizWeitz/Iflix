package br.edu.ifsp.arq.iflix.model;

import java.io.Serializable;

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private int id;
    private String nome;
    private String dataNasc;
    private String email;
    private String senha;
    private String imgPerfil;
    private UsuarioTipo tipo;

    public Usuario(int id, String nome, String dataNasc, String email, String senha, String imgPerfil, UsuarioTipo tipo) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.email = email;
        this.senha = senha;
        this.imgPerfil = imgPerfil;
        this.tipo = tipo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

	public UsuarioTipo getTipo() {
		return tipo;
	}

	public void setTipo(UsuarioTipo tipo) {
		this.tipo = tipo;
	}
    
}

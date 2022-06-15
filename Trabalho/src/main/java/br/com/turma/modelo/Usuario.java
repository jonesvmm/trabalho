package br.com.turma.modelo;

import java.util.Date;

public class Usuario {
	
	public Usuario() {
		
	}


	private Integer codigo;
	private String nome;
	private String sobrenome;
	private Date dataNascimento;
	private String login;
	private String senha;
	private String email;
	private String  telefone;
	
	



	public Integer getCodigo() {
		return codigo;
	}



	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getSobrenome() {
		return sobrenome;
	}



	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}



	public Date getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public Usuario(String nome,String sobrenome, Date dataNascimento, String login, String senha,String email, String telefone) {
		super();
		this.nome = nome;
		this.sobrenome=sobrenome;
		this.dataNascimento = dataNascimento;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.telefone= telefone;
		
	}



	}
	
	
		
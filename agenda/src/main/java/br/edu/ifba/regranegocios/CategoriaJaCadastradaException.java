package br.edu.ifba.regranegocios;


public class CategoriaJaCadastradaException extends Exception {
	
	private String nome;
	
	public CategoriaJaCadastradaException(String nome) {
		super("A Categoria "+ nome + " já existe, tente com outro nome");
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}

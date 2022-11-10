package br.edu.ifba.basicas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria implements Serializable {

	@Override
	public String toString() {
		return nome ;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String descricao;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	private List<Contato> contato;
	
	public Categoria() {}

	public Categoria(String nome, String descricao) {
		super();
		
		this.nome = nome;
		this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	public List<Contato> getContato() {
		return contato;
	}

	public void setContato(List<Contato> contato) {
		this.contato = contato;
	}

	public void adiciona(Contato contato) {
		
		if(this.contato==null) {
			
			List<Contato> contatos = new ArrayList<Contato>();
			this.setContato(contatos);
			this.getContato().add(contato);
			contato.setCategoria(this);
			 
		}else {
			
			this.getContato().add(contato);
			contato.setCategoria(this);
			
		}
		
		
		
	}
	
	
	
	
	

}

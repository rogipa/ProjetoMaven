package br.edu.ifba.basicas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Contato implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String observacao;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name="cartegoria_id", nullable=false)
	private Categoria categoria;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "contato_id")
	private List<Telefone> telefones;

	public Contato() {}
	
	public Contato( String nome, String observacao, Endereco endereco, Categoria categoria) {
		super();
		
		this.nome = nome;
		this.observacao = observacao;
		this.endereco = endereco;
		this.categoria = categoria;
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public void adicionaTelefone(Telefone telefone) {
		
		if(this.telefones == null) {
			
			List<Telefone> telefones = new ArrayList<Telefone>();
			
			this.setTelefones(telefones);
			this.getTelefones().add(telefone);
	
		
		}else {
			
			this.getTelefones().add(telefone);
			
		}
		
		
		
	}
	
	
	
	
	
	
}

package basica;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Pessoa implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	private String nome;
	private String email;
	
	@Transient
	private long qtdVeiculo;
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="pessoa_id")
	private List<Veiculo> veiculo;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Endereco endereco;

	public Pessoa() {}
	
	public Pessoa(String nome, String email, long qtdVeiculo) {
		this.nome = nome;
		this.email = email;
		this.qtdVeiculo = qtdVeiculo;
	}
	

	public Pessoa(String nome, String email) {
		super();
		
		this.nome = nome;
		this.email = email;
	}
	
	
	


	public long getQtdVeiculo() {
		return qtdVeiculo;
	}

	public void setQtdVeiculo(long qtdVeiculo) {
		this.qtdVeiculo = qtdVeiculo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public List<Veiculo> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}
	
	public void adicionaEnd(Endereco endereco) {
		this.setEndereco(endereco);
		endereco.setPessoa(this);
	}
	
	public void adicionaVeiculo(Veiculo veiculo) {
		 if(this.veiculo == null) {
			 List<Veiculo> v = new ArrayList<>();
			 this.setVeiculo(v);
			 this.getVeiculo().add(veiculo);
		 }else {
			 this.getVeiculo().add(veiculo);
		 }
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + ",End=" + endereco.getRua() + " ] ";
	}



}

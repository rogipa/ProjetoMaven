package basica;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Endereco implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String bairro;
	private String rua;
	private String numero;
	
	@OneToOne(mappedBy="endereco")
	private Pessoa pessoa;
	
	
	
		
	public Endereco() {}
	
	public Endereco(String bairro, String rua, String numero) {
		super();
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
	}
	
	
	


	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", bairro=" + bairro + ", rua=" + rua + ", numero=" + numero + "Pessoa=" + pessoa.getNome() + "]";
	}
	
	
	
	

	

}

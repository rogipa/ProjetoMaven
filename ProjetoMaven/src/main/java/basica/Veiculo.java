package basica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Veiculo implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String modelo;
	private String marca;
	
	@ManyToMany
	@JoinTable(name="historico_servicos")
	private List<Funcionario> funcionarios;
	



	public Veiculo(String modelo, String marca) {
		super();
		this.modelo = modelo;
		this.marca = marca;
	
	}
	
	
	
	public Veiculo() {}


	
	
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}



	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void adiciona(Funcionario funcionario) {
		if(this.funcionarios==null) {
		List<Funcionario> f = new ArrayList<Funcionario>();
		this.setFuncionarios(f);
		this.getFuncionarios().add(funcionario);
		funcionario.adiciona(this);
		}else {
			this.getFuncionarios().add(funcionario);
			funcionario.adiciona(this);
		}
		
	}



	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", pessoa=" +  "]";
	}
	
	
	
	
	

}

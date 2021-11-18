package basica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Funcionario implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String função;
	
	@ManyToMany(mappedBy="funcionarios")
	private List<Veiculo> veiculos;
	
	public Funcionario() {}
	
	public Funcionario(String nome, String função) {
		super();
		
		this.nome = nome;
		this.função = função;
	}
	
	
	

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
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

	public String getFunção() {
		return função;
	}

	public void setFunção(String função) {
		this.função = função;
	}
	
	public void adiciona(Veiculo veiculo) {
		if(this.veiculos==null) {
			List<Veiculo> v = new ArrayList<>();
			this.setVeiculos(v);
			this.getVeiculos().add(veiculo);
		}else {
			
			this.getVeiculos().add(veiculo);
			
		}
		
		
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", função=" + função + "]";
	}
	
	
	
	
	
	
	
	
	

}

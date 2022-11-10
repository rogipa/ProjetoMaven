package br.edu.ifba.regranegocios;

import java.util.List;

import br.edu.ifba.basicas.Endereco;
import br.edu.ifba.dao.EnderecoDao;

public class EnderecoRn {
	
	EnderecoDao end = new EnderecoDao();
	
	
	public void adicionaEndereco(Endereco endereco) {
		
		end.adicionaEndereco(endereco);
		
	}
	
	public List<Endereco> listarEndereco(){
		
		return end.listarEndereco();
		
	}
	
	public void atualizarEndereco(Endereco endereco) {
		
		end.atualizarEndereco(endereco);
		
	}
	
	public void removerEndereco(Endereco endereco) {
		
		end.removerEndereco(endereco);
		
	}
	
	public List<Endereco> procurarEnderecoRua(String rua){
		
		return end.procurarNomeRua(rua);
		
	}
	
	

}

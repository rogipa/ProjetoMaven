package br.edu.ifba.regranegocios;

import java.util.List;

import br.edu.ifba.basicas.Contato;
import br.edu.ifba.dao.ContatoDao;

public class ContatoRn {
	
	ContatoDao con = new ContatoDao();
	
	public void adicionarContato(Contato contato) {
		
//		Implementar código, não precisa de exceção, pois na agenda os nomes podem se repetir
		
		con.adicionaContato(contato);
		
	}
	
	public Contato procurarContatoId(int id) {
		return con.procurarContatoId(id);
	}
	
	public List<Contato> listarContato(){
		
		return con.listarContato();
		
	}
	
	public void atualizarContato(Contato contato) {
		
		con.atualizarContato(contato);
		
	}
	
	public void removerContato(Contato contato) {
		
		con.removerContato(contato);
		
	}
	
	public List<Contato> procurarContatoNome(String nome){
		
		return con.procurarContatoNome(nome);
		
	}

}
